package com.pmso.tugaflavours.init;

import java.util.Objects;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.world.biomes.AlentejoBiome;

import net.minecraft.data.BiomeProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			Tugaflavours.MOD_ID);
	
	public static void init() {
		BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
		//CakeBlock
	}
	
	public static final RegistryObject<Biome> ALENTEJO_BIOME=BIOMES.register("alentejo_biome", ()-> AlentejoBiome.buildBiome());
	
	public static void registerBiomes() {
		registerBiome(key(ALENTEJO_BIOME.get()), Type.PLAINS, Type.OVERWORLD);
	}
	
	private static void registerBiome(RegistryKey<Biome> biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 100));
		
		//BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.addTypes(biome, types);
	}
	
	private static RegistryKey<Biome> key(final Biome biome) {
		return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
	}
}
