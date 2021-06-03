package com.pmso.tugaflavours.client.blocks;

import com.pmso.tugaflavours.client.items.GrapeItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class GrapeBlock extends Block{
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;


	protected static VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	private RegistryObject<GrapeItem> grape;
	
	public GrapeBlock(RegistryObject<GrapeItem> redGrapes) {
		super(Block.Properties.create(Material.LEAVES)
				.zeroHardnessAndResistance()
				.sound(SoundType.CROP)
				.notSolid()
				.harvestLevel(1));
		
		this.grape=redGrapes;
	}

	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		
		String biome=Minecraft.getInstance().world.getBiome(pos).getRegistryName().toString().replace(":", ".");
		
		
		ItemStack stack= new ItemStack(this.grape.get(), 1);
		
		CompoundNBT nbt;
	    if (stack.hasTag())
	    {
	        nbt = stack.getTag();
	    }
	    else
	    {
	        nbt = new CompoundNBT();
	    }
	    
	    nbt.putString("biome", biome);
	    stack.setTag(nbt);
		
		
		if (!worldIn.isRemote() && !stack.isEmpty()) {
	         float f = 0.5F;
	         double d0 = (double)(worldIn.getRandom().nextFloat() * 0.5F) + 0.25D;
	         double d1 = (double)(worldIn.getRandom().nextFloat() * 0.5F) + 0.25D;
	         double d2 = (double)(worldIn.getRandom().nextFloat() * 0.5F) + 0.25D;
	         ItemEntity itementity = new ItemEntity((World) worldIn, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, stack);
	         itementity.setDefaultPickupDelay();
	         worldIn.addEntity(itementity);
	      }
	}
	
	@Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}