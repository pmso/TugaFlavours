package com.pmso.tugaflavours.client.blocks;

import java.util.stream.Stream;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class DishBlock extends Block{

	
	private static final VoxelShape SHAPE=Stream.of(
			Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
			Block.makeCuboidShape(2, 1, 1, 14, 2, 3),
			Block.makeCuboidShape(1, 1, 3, 3, 2, 14),
			Block.makeCuboidShape(2, 1, 13, 14, 2, 15),
			Block.makeCuboidShape(13, 1, 2, 15, 2, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public DishBlock() {
		super(Block.Properties.create(Material.GLASS)
				.zeroHardnessAndResistance()
				.sound(SoundType.GLASS)
				.harvestLevel(0)
				.harvestLevel(1));
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
    
    /**Change the block shadow -- Lower return values = more shadow*/
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}
