package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.effects.DrunkEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister
			.create(ForgeRegistries.POTIONS, Tugaflavours.MOD_ID);
	
	public static final RegistryObject<Effect> DRUNK = EFFECTS.register("drunk", ()-> new DrunkEffect());
	
}
