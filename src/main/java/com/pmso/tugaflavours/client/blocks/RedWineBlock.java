package com.pmso.tugaflavours.client.blocks;

import com.google.common.base.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RedWineBlock  extends FlowingFluidBlock{
	
	public RedWineBlock(Block.Properties properties, Supplier<? extends FlowingFluid> fluid)
	{
		super(fluid, properties);
	}

	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
	{
		if(!world.isRemote && !(entity instanceof ItemEntity) && !(entity instanceof BoatEntity))
		{
			if(!(entity instanceof PlayerEntity) || (!((PlayerEntity) entity).isCreative() && !(((PlayerEntity)entity).getRidingEntity() instanceof BoatEntity)))
				entity.attackEntityFrom(DamageSource.DROWN, 1.5F);
		}
	}
}
