package com.pmso.tugaflavours;

import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pmso.tugaflavours.init.ModBiomes;
import com.pmso.tugaflavours.init.ModBlocks;
import com.pmso.tugaflavours.init.ModItems;
import com.pmso.tugaflavours.init.ModSounds;
import com.pmso.tugaflavours.init.ModVanillaIntegration;
import com.pmso.tugaflavours.util.TugaFlavoursTabs;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tugaflavours")
public class Tugaflavours
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    
    public static final String MOD_ID="tugaflavours";
    public static final ItemGroup TAB= new TugaFlavoursTabs();

    public Tugaflavours() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ModSounds.init();
        ModItems.init();
        ModBlocks.init();
        ModBiomes.init();
        ModVanillaIntegration.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		ModBiomes.registerBiomes();
	}

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

}
