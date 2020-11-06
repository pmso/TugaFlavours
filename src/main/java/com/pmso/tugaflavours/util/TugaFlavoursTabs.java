package com.pmso.tugaflavours.util;

import java.util.Comparator;

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
	
	
	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(new Comparator<ItemStack>() {

			@Override
			public int compare(ItemStack a, ItemStack b) {
				// TODO Auto-generated method stub
				return a.getItem().getName().toString().compareToIgnoreCase(b.getItem().getName().toString());
			}
		});
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
