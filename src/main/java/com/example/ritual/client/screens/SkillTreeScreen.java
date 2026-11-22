package com.example.ritual.client.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import com.example.ritual.PlayerDataManager;
import java.util.ArrayList;
import java.util.List;

public class SkillTreeScreen extends Screen {
    private List<ButtonWidget> buttons = new ArrayList<>();
    private PlayerEntity player;
    
    private static final String[] SKILL_NAMES = {
        "Ether Source",
        "Solar Flow", 
        "Fast Reading",
        "Mana Efficiency",
        "Archmage Aegis",
        "Double Resonance"
    };
    
    private static final String[] SKILL_DESCRIPTIONS = {
        "+50 Max Mana per level",
        "+1 Mana Regen per level",
        "-20 ticks learning time per level",
        "-15% Mana cost per level",
        "Shield at low HP",
        "Chance for double cast"
    };
    
    public SkillTreeScreen() {
        super(Text.literal("Archmage Skill Tree"));
    }
    
    @Override
    protected void init() {
        buttons.clear();
        MinecraftClient client = MinecraftClient.getInstance();
        player = client.player;
        
        if (player == null) return;
        
        int centerX = width / 2;
        int centerY = height / 2;
        int top = centerY - 120;
        
        for (int i = 0; i < 6; i++) {
            PlayerDataManager.PlayerData data = PlayerDataManager.getData(player);
            int level = data.getSkillLevel(i);
            
            int yPos = top + i * 40;
            buttons.add(ButtonWidget.builder(
                Text.literal(SKILL_NAMES[i] + " (Level " + level + "/3)"), btn -> {
                    if (level < 3 && player.experienceLevel >= (level + 1) * 5) {
                        data.setSkillLevel(i, level + 1);
                        player.addExperienceLevels(-(level + 1) * 5);
                        init();
                    }
                }
            ).dimensions(centerX - 120, yPos, 240, 30).build());
        }
        
        buttons.add(ButtonWidget.builder(Text.literal("Close"), btn -> {
            close();
        }).dimensions(centerX - 40, top + 260, 80, 20).build());
        
        for (ButtonWidget button : buttons) {
            addDrawableChild(button);
        }
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        
        int centerX = width / 2;
        int centerY = height / 2;
        int top = centerY - 120;
        
        context.drawTextWithShadow(textRenderer, 
                                 Text.literal("Archmage Skill Tree"), 
                                 centerX - 70, top - 20, 0xFFD700);
        
        // Draw skill descriptions
        for (int i = 0; i < 6; i++) {
            int yPos = top + i * 40 + 32;
            context.drawTextWithShadow(textRenderer, 
                                     Text.literal(SKILL_DESCRIPTIONS[i]), 
                                     centerX - 115, yPos, 0xAAAAAA);
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
