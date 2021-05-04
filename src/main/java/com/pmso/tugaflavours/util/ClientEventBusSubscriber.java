package com.pmso.tugaflavours.util;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.init.ModBlocks;
import com.pmso.tugaflavours.init.ModFluids;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Tugaflavours.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ModBlocks.CORK_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModFluids.RED_WINE_FLUID.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(ModFluids.RED_WINE_FLUID_FLOWING.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(ModFluids.WHITE_WINE_FLUID.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(ModFluids.WHITE_WINE_FLUID_FLOWING.get(), RenderType.getTranslucent());
	}
}
