package com.pmso.tugaflavours.client.blocks.cork;

import java.util.Random;
import com.pmso.tugaflavours.init.ModBlocks;
import com.pmso.tugaflavours.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CorkLogBlock extends RotatedPillarBlock{

	public CorkLogBlock() {
		super(Block.Properties.from(Blocks.OAK_LOG));
	}

	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItemMainhand();
		if (stack.isEmpty()) {
			return ActionResultType.PASS;
		}
		
		if(stack.getItem() instanceof AxeItem) {
			worldIn.setBlockState(pos, ModBlocks.STRIPPED_CORK_LOG.get().getDefaultState());
			worldIn.playSound(player, pos, SoundType.WOOD.getBreakSound(), SoundCategory.BLOCKS, 0.6F, 1F);
			
			if (worldIn.isRemote()) {
				return ActionResultType.SUCCESS;
			}
			
			stack.damageItem(1, player, playerA -> playerA.sendBreakAnimation(handIn));
			
			Random random=new Random();
			int qtyDrop=random.nextInt(3)+1;
			
			if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.CORK.get(), qtyDrop))) {
				
				player.dropItem(new ItemStack(ModItems.CORK.get(), qtyDrop),true/*field not used*/);
			}
			/*if (player instanceof ServerPlayerEntity) {
				TRRecipeHandler.unlockTRRecipes((ServerPlayerEntity) playerIn);
			}*/
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.PASS;
	}
}
