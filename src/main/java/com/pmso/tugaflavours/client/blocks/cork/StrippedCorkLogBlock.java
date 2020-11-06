package com.pmso.tugaflavours.client.blocks.cork;

import java.util.Random;

import com.pmso.tugaflavours.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class StrippedCorkLogBlock extends RotatedPillarBlock {

	private VoxelShape SHAPE = Block.makeCuboidShape(1, 0, 1, 15, 16, 15);

	public StrippedCorkLogBlock() {
		super(Block.Properties.from(ModBlocks.CORK_LOG.get()).notSolid().tickRandomly());
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		super.randomTick(state, worldIn, pos, random);

		if (random.nextInt(50) == 0) {
			worldIn.setBlockState(pos, ModBlocks.CORK_LOG.get().getDefaultState());
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		// TODO Auto-generated method stub
		return SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
		// TODO Auto-generated method stub
		return SHAPE;
	}

}
