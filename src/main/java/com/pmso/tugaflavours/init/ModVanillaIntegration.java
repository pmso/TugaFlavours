package com.pmso.tugaflavours.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;

public class ModVanillaIntegration {

	public static void init() {
		
		//COMPOSTER ITEMS
		ComposterBlock.CHANCES.put(()->{return ModItems.CORK_SAPLING.get();}, 0.3f);
		ComposterBlock.CHANCES.put(()->{return ModItems.CORK_LEAVES.get();}, 0.3f);
		
	}
	
}
