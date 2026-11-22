package com.example.ritual.client;
import com.example.ritual.client.screens.SpellWheelScreen;
import com.example.ritual.client.screens.SkillTreeScreen;
import com.example.ritual.client.render.ManaBarRenderer;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class RitualClient implements ClientModInitializer {
    public static KeyBinding SPELL_WHEEL_KEY;
    public static KeyBinding SKILL_TREE_KEY;
    
    @Override
    public void onInitializeClient() {
        SPELL_WHEEL_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.ritual.spell_wheel",
            GLFW.GLFW_KEY_R,
            "category.ritual.magic"
        ));
        
        SKILL_TREE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.ritual.skill_tree",
            GLFW.GLFW_KEY_K,
            "category.ritual.magic"
        ));
        
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (SPELL_WHEEL_KEY.wasPressed()) {
                client.setScreen(new SpellWheelScreen());
            }
            if (SKILL_TREE_KEY.wasPressed()) {
                client.setScreen(new SkillTreeScreen());
            }
        });
        
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            ManaBarRenderer.render(drawContext, tickDelta);
        });
        
        System.out.println("Ritual Client initialized!");
    }
}
