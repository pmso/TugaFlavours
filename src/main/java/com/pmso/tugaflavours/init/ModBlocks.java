package com.pmso.tugaflavours.init;

import java.util.function.Supplier;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.CorkBlock;
import com.pmso.tugaflavours.client.blocks.CorkLeaves;
import com.pmso.tugaflavours.client.blocks.CorkLogBlock;
import com.pmso.tugaflavours.client.blocks.DishBlock;
import com.pmso.tugaflavours.client.blocks.FrancesinhaBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Tugaflavours.MOD_ID);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Blocks
	public static final RegistryObject<Block> CORK_BLOCK = BLOCKS.register("cork_block", CorkBlock::new);

	public static final RegistryObject<Block> CORK_LOG = BLOCKS.register("cork_log", CorkLogBlock::new);
	public static final RegistryObject<Block> CORK_PLANKS = BLOCKS.register("cork_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> CORK_LEAVES = BLOCKS.register("cork_leaves", CorkLeaves::new);

	public static final RegistryObject<Block> DISH_BLOCK = BLOCKS.register("dish_block", DishBlock::new);

	public static final RegistryObject<Block> FRANCESINHA_BLOCK = BLOCKS.register("francesinha_block",
			FrancesinhaBlock::new);

}
