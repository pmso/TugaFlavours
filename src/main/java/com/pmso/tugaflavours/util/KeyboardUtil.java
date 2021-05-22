package com.pmso.tugaflavours.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;

public class KeyboardUtil {

	private static final long MINECRAFT_WINDOW=Minecraft.getInstance().getMainWindow().getHandle();
	
	public static boolean isHolding(KeyBinding keybinding ){
		return InputMappings.isKeyDown(MINECRAFT_WINDOW, keybinding.getKey().getKeyCode());
	}
}
