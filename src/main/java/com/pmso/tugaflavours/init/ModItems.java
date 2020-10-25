package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.BlockItemBase;
import com.pmso.tugaflavours.client.items.ItemBase;
import com.pmso.tugaflavours.util.enums.ModArmourMaterial;
import com.pmso.tugaflavours.util.enums.ModItemTier;

import net.minecraft.item.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Tugaflavours.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Items
	public static final RegistryObject<Item> TUGA_COD = ITEMS.register("tuga_cod", ItemBase::new);
	public static final RegistryObject<Item> DRIED_COD = ITEMS.register("dried_cod", ItemBase::new);
	public static final RegistryObject<Item> CORK = ITEMS.register("cork", ItemBase::new);

	// Tools
	public static final RegistryObject<SwordItem> CORK_SWORD = ITEMS.register("cork_sword",
			() -> new SwordItem(ModItemTier.CORK, 2, -2.4f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<AxeItem> CORK_AXE = ITEMS.register("cork_axe",
			() -> new AxeItem(ModItemTier.CORK, 3, -3.1f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<PickaxeItem> CORK_PICKAXE = ITEMS.register("cork_pickaxe",
			() -> new PickaxeItem(ModItemTier.CORK, 1, -2.8f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<HoeItem> CORK_HOE = ITEMS.register("cork_hoe",
			() -> new HoeItem(ModItemTier.CORK, 1, -2.8f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ShovelItem> CORK_SHOVEL = ITEMS.register("cork_shovel",
			() -> new ShovelItem(ModItemTier.CORK, 1, -3.0f, new Item.Properties().group(Tugaflavours.TAB)));

	// Armours
	public static final RegistryObject<ArmorItem> CORK_HELMET = ITEMS.register("cork_helmet",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.HEAD,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_CHESTPLATE = ITEMS.register("cork_chestplate",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.CHEST,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_LEGGINGS = ITEMS.register("cork_leggings",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.LEGS,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_BOOTS = ITEMS.register("cork_boots",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.FEET,
					new Item.Properties().group(Tugaflavours.TAB)));

	// Block Items
	public static final RegistryObject<Item> CORK_BLOCK_ITEM = ITEMS.register("cork_block",
			() -> new BlockItemBase(ModBlocks.CORK_BLOCK.get()));

	public static final RegistryObject<Item> CORK_STAIRS_ITEM=ITEMS.register("cork_stairs", 
			()->new BlockItemBase(ModBlocks.CORK_STAIRS.get()));
	public static final RegistryObject<Item> CORK_FENCE_ITEM=ITEMS.register("cork_fence", 
			()->new BlockItemBase(ModBlocks.CORK_FENCE.get()));
	public static final RegistryObject<Item> CORK_FENCE_GATE_ITEM=ITEMS.register("cork_fence_gate", 
			()->new BlockItemBase(ModBlocks.CORK_FENCE_GATE.get()));
	public static final RegistryObject<Item> CORK_BUTTON_ITEM=ITEMS.register("cork_button", 
			()->new BlockItemBase(ModBlocks.CORK_BUTTON.get()));
	public static final RegistryObject<Item> CORK_PRESSURE_PLATE_ITEM=ITEMS.register("cork_pressure_plate", 
			()->new BlockItemBase(ModBlocks.CORK_PRESSURE_PLATE.get()));
	public static final RegistryObject<Item> CORK_SLAB_ITEM=ITEMS.register("cork_slab", 
			()->new BlockItemBase(ModBlocks.CORK_SLAB.get()));

	public static final RegistryObject<Item> CORK_LOG_ITEM = ITEMS.register("cork_log", 
			()-> new BlockItemBase(ModBlocks.CORK_LOG.get()));
	public static final RegistryObject<Item> CORK_PLANKS_ITEM = ITEMS.register("cork_planks", 
			()-> new BlockItemBase(ModBlocks.CORK_PLANKS.get()));
	
	public static final RegistryObject<Item> CORK_PLANK_STAIRS_ITEM=ITEMS.register("cork_plank_stairs", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_STAIRS.get()));
	public static final RegistryObject<Item> CORK_PLANK_FENCE_ITEM=ITEMS.register("cork_plank_fence", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_FENCE.get()));
	public static final RegistryObject<Item> CORK_PLANK_FENCE_GATE_ITEM=ITEMS.register("cork_plank_fence_gate", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_FENCE_GATE.get()));
	public static final RegistryObject<Item> CORK_PLANK_BUTTON_ITEM=ITEMS.register("cork_plank_button", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_BUTTON.get()));
	public static final RegistryObject<Item> CORK_PLANK_PRESSURE_PLATE_ITEM=ITEMS.register("cork_plank_pressure_plate", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_PRESSURE_PLATE.get()));
	public static final RegistryObject<Item> CORK_PLANK_SLAB_ITEM=ITEMS.register("cork_plank_slab", 
			()->new BlockItemBase(ModBlocks.CORK_PLANK_SLAB.get()));

	public static final RegistryObject<Item> CORK_LEAVES=ITEMS.register("cork_leaves", ()->new BlockItemBase(ModBlocks.CORK_LEAVES.get()));
	
	public static final RegistryObject<Item> CORK_SAPLING = ITEMS.register("cork_sapling", ()->new BlockItemBase(ModBlocks.CORK_SAPLING.get()));
	
	
	public static final RegistryObject<Item> DISH_ITEM = ITEMS.register("dish_block",
			() -> new BlockItemBase(ModBlocks.DISH_BLOCK.get()));

	public static final RegistryObject<Item> FRANCESINHA_ITEM = ITEMS.register("francesinha_block",
			() -> new BlockItemBase(ModBlocks.FRANCESINHA_BLOCK.get()));

	// Record Item
	public static final RegistryObject<MusicDiscItem> HINO_DISC = ITEMS.register("hino_disc",
			() -> new MusicDiscItem(15, ModSounds.LAZY_HINO_MUSIC, new Item.Properties().group(Tugaflavours.TAB).maxStackSize(1).rarity(Rarity.RARE)));
}
