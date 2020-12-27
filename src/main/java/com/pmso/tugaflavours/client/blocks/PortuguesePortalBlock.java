package com.pmso.tugaflavours.client.blocks;

import java.lang.System.Logger;
import java.util.Random;
import java.util.stream.Collectors;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.init.ModBlocks;
import com.pmso.tugaflavours.util.TugaFlavoursTabs;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.ITeleporter;

public class PortuguesePortalBlock extends Block {

	public static final IntegerProperty LIT = IntegerProperty.create("lit", 0, 1);

	public PortuguesePortalBlock() {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3f, 3.0f).sound(SoundType.STONE)
				.tickRandomly());
		this.setDefaultState(this.getDefaultState().with(LIT, 0));
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);

		if (!worldIn.isRemote && worldIn.getBlockState(pos).get(LIT) == 1) {
			MinecraftServer server = worldIn.getServer();

			if ((!entityIn.isBeingRidden()) && (entityIn.getPassengers().isEmpty())) {
				boolean inOverworld = entityIn.world.getDimensionKey() != getPortugalDimension();
				if ((entityIn instanceof ServerPlayerEntity)) {
					ServerPlayerEntity thePlayer = (ServerPlayerEntity) entityIn;
					if (inOverworld) {
						ServerWorld dimWorld = server.getWorld(getPortugalDimension());
						if (dimWorld != null) {
							teleportEntity(thePlayer, dimWorld, pos, true);
						}
					} else {
						ServerWorld dimWorld = server.getWorld(World.OVERWORLD);
						if (dimWorld != null) {
							teleportEntity(thePlayer, dimWorld, pos, false);
						}
					}
				}
				if (!(entityIn instanceof PlayerEntity)) {
					if (inOverworld) {
						ServerWorld dimWorld = server.getWorld(getPortugalDimension());
						if (dimWorld != null) {
							teleportEntity(entityIn, dimWorld, pos, true);
						}
					} else {
						ServerWorld dimWorld = server.getWorld(World.OVERWORLD);
						if (dimWorld != null) {
							teleportEntity(entityIn, dimWorld, pos, false);
						}
					}
				}
			}
		}
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {

		ItemStack stack = player.getHeldItemMainhand();
		if (stack.isEmpty()) {
			return ActionResultType.PASS;
		}
		
		
		
		if (stack.getItem().getRegistryName().toString().equals("tugaflavours:dried_cod")) {
			
			stack.setCount(stack.getCount()-1);
			if (worldIn.isRemote) {
				spawnParticles(worldIn, pos);
			} else {
				activate(state, worldIn, pos);
			}

			ItemStack itemstack = player.getHeldItem(handIn);
			return itemstack.getItem() instanceof BlockItem
					&& (new BlockItemUseContext(player, handIn, itemstack, hit)).canPlace() ? ActionResultType.PASS
							: ActionResultType.SUCCESS;

		}
		return ActionResultType.PASS;
	}

	private static void activate(BlockState state, World world, BlockPos pos) {
		spawnParticles(world, pos);
		if (state.get(LIT) == 0) {
			world.setBlockState(pos, state.with(LIT, 1), 3);
		}
	}

	/**
	 * Called periodically clientside on blocks near the player to show effects
	 * (like furnace fire particles). Note that this method is unrelated to
	 * {@link randomTick} and {@link #needsRandomTick}, and will always be called
	 * regardless of whether the block can receive random update ticks
	 */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (stateIn.get(LIT) != 0) {
			spawnParticles(worldIn, pos);
		}

	}

	private static void spawnParticles(World world, BlockPos worldIn) {
		double d0 = 0.5625D;
		Random random = world.rand;

		for (Direction direction : Direction.values()) {
			BlockPos blockpos = worldIn.offset(direction);
			if (!world.getBlockState(blockpos).isOpaqueCube(world, blockpos)) {
				Direction.Axis direction$axis = direction.getAxis();
				double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getXOffset()
						: (double) random.nextFloat();
				double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getYOffset()
						: (double) random.nextFloat();
				double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getZOffset()
						: (double) random.nextFloat();
				world.addParticle(RedstoneParticleData.REDSTONE_DUST, (double) worldIn.getX() + d1,
						(double) worldIn.getY() + d2, (double) worldIn.getZ() + d3, 0.0D, 0.0D, 0.0D);
			}
		}

	}

	public RegistryKey<World> getPortugalDimension() {
		ResourceLocation resourcelocation = new ResourceLocation("tugaflavours:portugal_dim");
		RegistryKey<World> registrykey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, resourcelocation);
		return registrykey;
	}

	private Entity teleportEntity(Entity entity, ServerWorld endpointWorld, BlockPos endpoint, boolean otherDim) {
		if (otherDim) {
			// endpoint = new BlockPos(0, 35, 0);
			placeInPortal(entity, endpointWorld);
		} else {
			if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getBedPosition().isPresent()) {
				BlockPos bedPos = ((PlayerEntity) entity).getBedPosition().get();
				endpoint = bedPos;
				entity.setLocationAndAngles(bedPos.getX() + 0.5D, bedPos.getY() + 1.5D, bedPos.getZ() + 0.5D, 0.0F,
						0.0F);
			} else {
				BlockPos height = entity.world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
						new BlockPos(entity.getPositionVec()));
				endpoint = height.east(1);// To not sit again in the portal
				entity.setLocationAndAngles(height.getX() + 0.5D, height.getY() + 0.5D, height.getZ() + 0.5D,
						entity.rotationYaw, 0.0F);
			}
		}
		if (entity instanceof ServerPlayerEntity) {
			ServerPlayerEntity player = (ServerPlayerEntity) entity;
			player.teleport(endpointWorld, endpoint.getX() + 0.5D, endpoint.getY() + 0.5D, endpoint.getZ() + 0.5D,
					entity.rotationYaw, entity.rotationPitch);
			return player;
		}

		entity.detach();
		entity.changeDimension(endpointWorld);
		Entity teleportedEntity = entity.getType().create(endpointWorld);
		if (teleportedEntity == null) {
			return entity;
		}
		teleportedEntity.copyDataFromOld(entity);
		teleportedEntity.setLocationAndAngles(endpoint.getX() + 0.5D, endpoint.getY() + 0.5D, endpoint.getZ() + 0.5D,
				entity.rotationYaw, entity.rotationPitch);
		teleportedEntity.setRotationYawHead(entity.rotationYaw);
		endpointWorld.addFromAnotherDimension(teleportedEntity);
		return teleportedEntity;
	}

	public void placeInPortal(Entity entity, ServerWorld serverWorld) {
		// entity.setPositionAndRotation(0, 33, 0, 0, 0);
		entity.setMotion(0, 0, 0);
		BlockPos portalBottom = entity.world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				new BlockPos(entity.getPositionVec()));
		portalBottom = portalBottom.down(4);

		// Clearing area with air
		for (BlockPos pos : BlockPos.getAllInBox(portalBottom.add(-2, 0, -2), portalBottom.add(2, 0, 2))
				.map(BlockPos::toImmutable).collect(Collectors.toList())) {
			serverWorld.setBlockState(pos.up(1), Blocks.AIR.getDefaultState());
			serverWorld.setBlockState(pos.up(2), Blocks.AIR.getDefaultState());
			serverWorld.setBlockState(pos.up(3), Blocks.AIR.getDefaultState());
		}

		for (BlockPos pos : BlockPos.getAllInBox(portalBottom.add(-2, 0, -2), portalBottom.add(2, 0, 2))
				.map(BlockPos::toImmutable).collect(Collectors.toList())) {
			serverWorld.setBlockState(pos, Blocks.STONE_BRICKS.getDefaultState());
			serverWorld.setBlockState(pos.up(4), Blocks.STONE_BRICKS.getDefaultState());
		}
		for (int i = 1; i < 4; i++) {
			serverWorld.setBlockState(portalBottom.add(2, 0, 2).up(i), Blocks.STONE_BRICKS.getDefaultState());
			serverWorld.setBlockState(portalBottom.add(2, 0, -2).up(i), Blocks.STONE_BRICKS.getDefaultState());
			serverWorld.setBlockState(portalBottom.add(-2, 0, 2).up(i), Blocks.STONE_BRICKS.getDefaultState());
			serverWorld.setBlockState(portalBottom.add(-2, 0, -2).up(i), Blocks.STONE_BRICKS.getDefaultState());
		}

		serverWorld.setBlockState(portalBottom.up(4), Blocks.GLOWSTONE.getDefaultState());
		serverWorld.setBlockState(portalBottom, ModBlocks.PORTUGUESE_PORTAL_BLOCK.get().getDefaultState());
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(LIT);
	}

}
