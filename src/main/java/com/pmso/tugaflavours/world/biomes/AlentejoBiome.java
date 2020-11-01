package com.pmso.tugaflavours.world.biomes;


import com.pmso.tugaflavours.world.feature.CorkTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class AlentejoBiome {

	public static Biome buildBiome() {
		final MobSpawnInfo.Builder mobSpawnInfoBuilder = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.withHostileMobs(mobSpawnInfoBuilder, 19, 1, 100);
		mobSpawnInfoBuilder.withSpawner(EntityClassification.CREATURE,
				new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));

		final BiomeGenerationSettings.Builder biomeGenerationSettingBuilder = new BiomeGenerationSettings.Builder()
				.withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
		DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeGenerationSettingBuilder);
		biomeGenerationSettingBuilder.withStructure(StructureFeatures.RUINED_PORTAL);

		//biomeGenerationSettingBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PLAIN_VEGETATION);
		//biomeGenerationSettingBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
		biomeGenerationSettingBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.TREE.withConfiguration(CorkTree.CORK_TREE_CONFIG)
				.withPlacement(Placement.CHANCE.configure(new ChanceConfig(3))
						));

		biomeGenerationSettingBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_SAVANNA);
	      
		DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettingBuilder);
		DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettingBuilder);

		DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGenerationSettingBuilder);
		DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettingBuilder);
		DefaultBiomeFeatures.withDisks(biomeGenerationSettingBuilder);

		Biome alentejo = new Biome.Builder().precipitation(Biome.RainType.RAIN)
				.temperature(0.8f)
				.depth(0.125f)
				.scale(0.05f)
				.downfall(0.4f)
				.withMobSpawnSettings(mobSpawnInfoBuilder.copy())
				.withGenerationSettings(biomeGenerationSettingBuilder.build())
				.setEffects(new BiomeAmbience.Builder()
						.setWaterColor(4159204)
						.setWaterFogColor(329011)
						.setFogColor(12638463)
						.withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
						.withGrassColor(14870036)
						.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
				.category(Biome.Category.SAVANNA).build();
		
		return alentejo;

	}
	
	private static int getSkyColorWithTemperatureModifier(float temperature) {
	      float lvt_1_1_ = temperature / 3.0F;
	      lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
	      return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	   }
}
