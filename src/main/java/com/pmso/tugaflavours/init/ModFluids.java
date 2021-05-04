package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.fluids.RedWineFluid;
import com.pmso.tugaflavours.client.fluids.WhiteWineFluid;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Tugaflavours.MOD_ID);

	public static final RegistryObject<Fluid> RED_WINE_FLUID = FLUIDS.register("red_wine_fluid", ()-> new RedWineFluid.Source());
	public static final RegistryObject<Fluid> RED_WINE_FLUID_FLOWING = FLUIDS.register("red_wine_fluid_flowing", ()-> new RedWineFluid.Flowing());
	
	public static final RegistryObject<Fluid> WHITE_WINE_FLUID = FLUIDS.register("white_wine_fluid", WhiteWineFluid.Source::new);
	public static final RegistryObject<Fluid> WHITE_WINE_FLUID_FLOWING = FLUIDS.register("white_wine_fluid_flowing", WhiteWineFluid.Flowing::new);
	
}
