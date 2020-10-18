package com.pmso.tugaflavours.client.blocks;

import java.util.stream.Stream;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class DishBlock extends Block{

	private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N=Stream.of(
			Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
			Block.makeCuboidShape(2, 1, 1, 14, 2, 3),
			Block.makeCuboidShape(1, 1, 3, 3, 2, 14),
			Block.makeCuboidShape(2, 1, 13, 14, 2, 15),
			Block.makeCuboidShape(13, 1, 2, 15, 2, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	
	
	public DishBlock() {
		super(Block.Properties.create(Material.GLASS)
				.hardnessAndResistance(0.0f,3.0f)
				.sound(SoundType.GLASS)
				.notSolid()
				.harvestLevel(1));
	}
}
