package com.pmso.tugaflavours.client.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item{

	public ItemBase() {
		super(new Item.Properties().group(ItemGroup.FOOD));//Mudar depois para um itemgroup custom
	}

}
