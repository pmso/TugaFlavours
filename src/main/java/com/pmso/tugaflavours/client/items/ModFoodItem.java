package com.pmso.tugaflavours.client.items;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ModFoodItem extends Item {
	
	public ModFoodItem(int hunger, float saturation) {
		super(new Item.Properties().group(Tugaflavours.TAB)
				.food(new Food.Builder()
						.hunger(hunger)
						.saturation(saturation)
						.build()));
	}

}
