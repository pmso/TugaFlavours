package com.pmso.tugaflavours.client.blocks;

import com.pmso.tugaflavours.Tugaflavours;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PortuguesePortalBlock extends Block {

	public PortuguesePortalBlock() {
		super(Block.Properties.create(Material.ROCK)
				.hardnessAndResistance(1.3f, 3.0f)
				.sound(SoundType.GLASS));
		// this.setDefaultState(this.stateContainer.getBaseState().with(AXIS,
		// Direction.Axis.X));
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		// TODO Auto-generated method stub
		super.onEntityWalk(worldIn, pos, entityIn);
		Tugaflavours.LOGGER.debug("Walk");
	}

}
