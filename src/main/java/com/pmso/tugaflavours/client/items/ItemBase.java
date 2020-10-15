package com.pmso.tugaflavours.client.items;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item{

	public ItemBase() {
		super(new Item.Properties().group(Tugaflavours.TAB));//Mudar depois para um itemgroup custom
	}

}
