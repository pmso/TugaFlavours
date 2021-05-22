package com.pmso.tugaflavours.client.blocks;

import com.pmso.tugaflavours.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class RedGrapeBlock extends Block{

	public RedGrapeBlock() {
		super(Block.Properties.create(Material.LEAVES)
				.zeroHardnessAndResistance()
				.sound(SoundType.CROP)
				.notSolid()
				.harvestLevel(1));
	}

	
	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		
		String biome=Minecraft.getInstance().world.getBiome(pos).getRegistryName().toString().replace(":", ".");
		
		
		ItemStack stack= new ItemStack(ModItems.RED_GRAPES.get(), 1);
		
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
}
