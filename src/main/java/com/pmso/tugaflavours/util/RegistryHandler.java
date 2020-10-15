package com.pmso.tugaflavours.util;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.BlockItemBase;
import com.pmso.tugaflavours.client.blocks.CorkBlock;
import com.pmso.tugaflavours.client.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler  {

	public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS, Tugaflavours.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, Tugaflavours.MOD_ID);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//Items
	public static final RegistryObject<Item> TUGA_COD=ITEMS.register("tuga_cod", ItemBase::new);
	public static final RegistryObject<Item> DRIED_COD=ITEMS.register("dried_cod", ItemBase::new);
	public static final RegistryObject<Item> CORK=ITEMS.register("cork", ItemBase::new);
	
	
	//Blocks
	public static final RegistryObject<Block> CORK_BLOCK=BLOCKS.register("cork_block", CorkBlock::new);
	
	//Block Items
	public static final RegistryObject<Item> CORK_BLOCK_ITEM=ITEMS.register("cork_block", ()->new BlockItemBase(CORK_BLOCK.get()));
	
}
