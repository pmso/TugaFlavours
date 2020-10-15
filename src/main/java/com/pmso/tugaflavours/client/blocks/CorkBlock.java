package com.pmso.tugaflavours.client.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CorkBlock extends Block{
	public CorkBlock() {
		super(Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(1.3f,3.0f)
				.sound(SoundType.CLOTH)
				.harvestLevel(1)
				.harvestTool(ToolType.AXE)
				);
	}

}
