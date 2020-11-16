package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.DishBlock;
import com.pmso.tugaflavours.client.blocks.FrancesinhaBlock;
import com.pmso.tugaflavours.client.blocks.ModSaplingBlock;
import com.pmso.tugaflavours.client.blocks.PortuguesePortalBlock;
import com.pmso.tugaflavours.client.blocks.cork.CorkBlock;
import com.pmso.tugaflavours.client.blocks.cork.CorkLeaves;
import com.pmso.tugaflavours.client.blocks.cork.CorkLogBlock;
import com.pmso.tugaflavours.client.blocks.cork.StrippedCorkLogBlock;
import com.pmso.tugaflavours.world.feature.CorkTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Tugaflavours.MOD_ID);


	// Blocks
	public static final RegistryObject<Block> CORK_BLOCK = BLOCKS.register("cork_block", CorkBlock::new);
	
	public static final RegistryObject<Block> CORK_STAIRS = BLOCKS.register("cork_stairs",
			() -> new StairsBlock(() -> CORK_BLOCK.get().getDefaultState(),
					Block.Properties.from(ModBlocks.CORK_BLOCK.get())));
	public static final RegistryObject<Block> CORK_FENCE = BLOCKS.register("cork_fence",
			() -> new FenceBlock(Block.Properties.from(ModBlocks.CORK_BLOCK.get())));
	public static final RegistryObject<Block> CORK_FENCE_GATE = BLOCKS.register("cork_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(ModBlocks.CORK_BLOCK.get())));
	public static final RegistryObject<Block> CORK_BUTTON = BLOCKS.register("cork_button",
			() -> new WoodButtonBlock(Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> CORK_PRESSURE_PLATE = BLOCKS.register("cork_pressure_plate",
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> CORK_SLAB = BLOCKS.register("cork_slab",
			() -> new SlabBlock(Block.Properties.from(ModBlocks.CORK_BLOCK.get())));

	public static final RegistryObject<Block> CORK_LOG = BLOCKS.register("cork_log", CorkLogBlock::new);
	public static final RegistryObject<Block> STRIPPED_CORK_LOG = BLOCKS.register("stripped_cork_log", StrippedCorkLogBlock::new);
	public static final RegistryObject<Block> CORK_PLANKS = BLOCKS.register("cork_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> CORK_PLANK_STAIRS = BLOCKS.register("cork_plank_stairs",
			() -> new StairsBlock(() -> CORK_PLANKS.get().getDefaultState(),
					Block.Properties.from(ModBlocks.CORK_PLANKS.get())));
	public static final RegistryObject<Block> CORK_PLANK_FENCE = BLOCKS.register("cork_plank_fence",
			() -> new FenceBlock(Block.Properties.from(ModBlocks.CORK_PLANKS.get())));
	public static final RegistryObject<Block> CORK_PLANK_FENCE_GATE = BLOCKS.register("cork_plank_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(ModBlocks.CORK_PLANKS.get())));
	public static final RegistryObject<Block> CORK_PLANK_BUTTON = BLOCKS.register("cork_plank_button",
			() -> new WoodButtonBlock(Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> CORK_PLANK_PRESSURE_PLATE = BLOCKS.register("cork_plank_pressure_plate",
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> CORK_PLANK_SLAB = BLOCKS.register("cork_plank_slab",
			() -> new SlabBlock(Block.Properties.from(ModBlocks.CORK_PLANKS.get())));
	
	public static final RegistryObject<Block> CORK_LEAVES = BLOCKS.register("cork_leaves", CorkLeaves::new);
	
	public static final RegistryObject<Block> CORK_SAPLING= BLOCKS.register("cork_sapling", 
			()-> new ModSaplingBlock(()-> new CorkTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> DISH_BLOCK = BLOCKS.register("dish_block", DishBlock::new);

	public static final RegistryObject<Block> FRANCESINHA_BLOCK = BLOCKS.register("francesinha_block",
			FrancesinhaBlock::new);
	
	public static final RegistryObject<Block> PORTUGUESE_PORTAL_BLOCK=BLOCKS.register("portuguese_portal_block", PortuguesePortalBlock::new);

}
