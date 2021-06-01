package com.pmso.tugaflavours.client.effects;

import org.apache.logging.log4j.Level;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class DrunkEffect extends Effect {

	public DrunkEffect() {
		super(EffectType.HARMFUL, 0x3eb29e);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		// TODO Auto-generated method stub
		Tugaflavours.LOGGER.log(Level.INFO, "Angle: "+entityLivingBaseIn.moveStrafing);
		((PlayerEntity)entityLivingBaseIn).getFoodStats().addStats(amplifier + 1, 1.0F);
	}
	
	@Override
	public boolean isInstant() {
		// TODO Auto-generated method stub
		return false;
	}

}
