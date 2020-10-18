package com.pmso.tugaflavours.util;

import java.util.Collections;

import com.pmso.tugaflavours.init.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TugaFlavoursTabs extends ItemGroup{

	public TugaFlavoursTabs() {
		super("tugaFlavoursTab");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.TUGA_COD.get());
	}
}
