package com.pmso.tugaflavours.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ModKeyBindings {
	public static final KeyBinding ITEM_DESC = new KeyBinding("key.item_desc", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.tugaflavours");

	public static void register() {
		ClientRegistry.registerKeyBinding(ITEM_DESC);
	}}
