package com.pmso.tugaflavours.client.items;

import java.util.List;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.init.ModKeyBindings;
import com.pmso.tugaflavours.util.KeyboardUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ModFoodItem extends Item {
	
	//private String moreInfoTootip=TextFormatting.GRAY+"Click "+ I18n.format("key.item_desc")+I18n.format("tugaflavours:key.item_desc") +" key for more info"+TextFormatting.GRAY;
	private String moreInfoTootip=TextFormatting.GRAY+"Click Item Desc key for more info";
	private String info;
	
	
	
	public ModFoodItem(int hunger, float saturation) {
		super(new Item.Properties().group(Tugaflavours.TAB)
				.food(new Food.Builder()
						.hunger(hunger)
						.saturation(saturation)
						.build()));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(KeyboardUtil.isHolding(ModKeyBindings.ITEM_DESC)) {
			info=Minecraft.getInstance().world.getBiome(Minecraft.getInstance().player.getPosition()).getRegistryName().toString().replace(":", ".");
			//tooltip.add(new TranslationTextComponent(info));
			tooltip.add(new TranslationTextComponent("biome."+info));//"biome.minecraft.plains"
		}else {
			tooltip.add(new StringTextComponent(moreInfoTootip));
		}
	}

}
