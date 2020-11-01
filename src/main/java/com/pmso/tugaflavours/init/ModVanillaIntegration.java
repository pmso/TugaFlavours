package com.pmso.tugaflavours.init;

import net.minecraft.block.ComposterBlock;

public class ModVanillaIntegration {

	public static void init() {
		
		//COMPOSTER ITEMS
		ComposterBlock.CHANCES.put(()->{return ModItems.CORK_SAPLING.get();}, 0.3f);
		ComposterBlock.CHANCES.put(()->{return ModItems.CORK_LEAVES.get();}, 0.3f);
		
	}
	
}
