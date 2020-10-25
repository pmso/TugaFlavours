package com.pmso.tugaflavours.world.feature;

import java.util.Random;

import com.pmso.tugaflavours.init.ModBlocks;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;

public class CorkTree extends Tree {

	public static final BaseTreeFeatureConfig CORK_TREE_CONFIG= (new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.CORK_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.CORK_LEAVES.get().getDefaultState()), 
			new AcaciaFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0)), 
			new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2)))./*func_236700_a_*/setIgnoreVines().build();

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
		return Feature.TREE.withConfiguration(CORK_TREE_CONFIG);
	}

}
