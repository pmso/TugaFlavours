package com.pmso.tugaflavours.util.enums;

import java.util.function.Supplier;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.init.ModItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModArmourMaterial implements IArmorMaterial{
	
    CORK(Tugaflavours.MOD_ID+":cork",10,new int[] { 1, 3, 3, 1 },18, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0, () -> { return Ingredient.fromItems(ModItems.CORK.get()); },0);

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor; //Durability, Iron=15, Diamond=33, Gold=7, Leather=5
    private final int[] damageReductionAmountArray; //Armor Bar Protection, 1 = 1/2 armor bar
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness; //Increases Protection, 0.0F=Iron/Gold/Leather, 2.0F=Diamond, 3.0F=Netherite
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance; //1.0F=No Knockback, 0.0F=Disabled 
	
	ModArmourMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
		this.name=name;
		this.maxDamageFactor=maxDamageFactor;
		this.damageReductionAmountArray=damageReductionAmountArray;
		this.enchantability=enchantability;
		this.soundEvent=soundEvent;
		this.toughness=toughness;
		this.repairMaterial=repairMaterial;
		this.knockbackResistance=knockbackResistance;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override /*func_230304_f_*/
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

	@Override
	public SoundEvent getSoundEvent() {
		return soundEvent;
	}

	@Override
	public float getToughness() {
		return toughness;
	}


}
