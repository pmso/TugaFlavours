package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.CorkBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, Tugaflavours.MOD_ID);
	
	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	

	//Blocks
	public static final RegistryObject<Block> CORK_BLOCK=BLOCKS.register("cork_block", CorkBlock::new);
	
	public static final RegistryObject<Block> DISH_BLOCK=BLOCKS.register("dish_block", CorkBlock::new);
	
	public static final RegistryObject<Block> FRANCESINHA_BLOCK=BLOCKS.register("francesinha_block", CorkBlock::new);
}
