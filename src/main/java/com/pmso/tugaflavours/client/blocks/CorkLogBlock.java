package com.pmso.tugaflavours.client.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class CorkLogBlock extends RotatedPillarBlock{

	public CorkLogBlock() {
		super(Block.Properties.from(Blocks.OAK_LOG));
	}

}
