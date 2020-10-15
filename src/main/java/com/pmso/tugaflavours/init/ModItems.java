package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.BlockItemBase;
import com.pmso.tugaflavours.client.items.ItemBase;
import com.pmso.tugaflavours.client.tools.ModItemTier;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS, Tugaflavours.MOD_ID);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//Items
	public static final RegistryObject<Item> TUGA_COD=ITEMS.register("tuga_cod", ItemBase::new);
	public static final RegistryObject<Item> DRIED_COD=ITEMS.register("dried_cod", ItemBase::new);
	public static final RegistryObject<Item> CORK=ITEMS.register("cork", ItemBase::new);
	
	//Tools
	public static final RegistryObject<SwordItem> CORK_SWORD=ITEMS.register("cork_sword", 
			()->new SwordItem(ModItemTier.CORK, 1, -2.4f, new Item.Properties().group(Tugaflavours.TAB)));
		
	//Block Items
	public static final RegistryObject<Item> CORK_BLOCK_ITEM=ITEMS.register("cork_block", ()->new BlockItemBase(ModBlocks.CORK_BLOCK.get()));	
}
