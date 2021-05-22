package com.pmso.tugaflavours.client.items;

import java.util.List;

import com.pmso.tugaflavours.init.ModKeyBindings;
import com.pmso.tugaflavours.util.KeyboardUtil;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class GrapeItem extends ModFoodItem {

	public GrapeItem(int hunger, float saturation) {
		super(hunger,saturation);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.hasTag() && stack.getTag().contains("biome"))
        {
            info=stack.getTag().getString("biome");
        }
		
		if(KeyboardUtil.isHolding(ModKeyBindings.ITEM_DESC)) {
			tooltip.add(new TranslationTextComponent("%s%s",new StringTextComponent(TextFormatting.GREEN+"Biome: "+TextFormatting.GRAY),new TranslationTextComponent("biome."+info)));//"biome.minecraft.plains"
		}else {
			tooltip.add(new StringTextComponent(moreInfoTootip));
		}
	}

}
