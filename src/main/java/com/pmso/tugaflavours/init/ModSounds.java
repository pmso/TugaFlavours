package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister
			.create(ForgeRegistries.SOUND_EVENTS, Tugaflavours.MOD_ID);

	public static void init() {
		SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final Lazy<SoundEvent> LAZY_HINO_MUSIC= Lazy.of(()-> new SoundEvent(new ResourceLocation(Tugaflavours.MOD_ID,"disc.hino")));
	
	// Records
	public static final RegistryObject<SoundEvent> HINO_MUSIC = SOUNDS.register("hino_music", LAZY_HINO_MUSIC);

}
