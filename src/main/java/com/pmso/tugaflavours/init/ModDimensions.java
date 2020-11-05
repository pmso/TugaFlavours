package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tugaflavours.MOD_ID)
public class ModDimensions {
	
	private static String PORTUGAL_DIM_NAME="portugal_dim";
	
	public static final RegistryKey<DimensionType> PORTUGAL_TYPE = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, Tugaflavours.prefix(PORTUGAL_DIM_NAME));
	public static final RegistryKey<World> PORTUGAL_DIM = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, Tugaflavours.prefix(PORTUGAL_DIM_NAME));
}
