package com.example.ritual.client.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import com.example.ritual.SpellRegistry;
import com.example.ritual.PlayerDataManager;
import java.util.ArrayList;
import java.util.List;

public class SpellWheelScreen extends Screen {
    private int currentCircle = 0;
    private List<ButtonWidget> buttons = new ArrayList<>();
    private PlayerEntity player;
    private long closeTime = 0;
    
    public SpellWheelScreen() {
        super(Text.literal("Spell Wheel"));
    }
    
    @Override
    protected void init() {
        buttons.clear();
        MinecraftClient client = MinecraftClient.getInstance();
        player = client.player;
        closeTime = System.currentTimeMillis() + 10000; // 10 seconds
        
        if (player == null) return;
        
        int centerX = width / 2;
        int centerY = height / 2;
        
        // Circle navigation buttons
        buttons.add(ButtonWidget.builder(Text.literal("<"), btn -> {
            if (currentCircle > 0) {
                currentCircle--;
                init();
            }
        }).dimensions(centerX - 60, centerY - 10, 30, 20).build());
        
        buttons.add(ButtonWidget.builder(Text.literal("Circle " + (currentCircle + 1) + "/5"), btn -> {
            // No action
        }).dimensions(centerX - 30, centerY - 10, 60, 20).build());
        
        buttons.add(ButtonWidget.builder(Text.literal(">"), btn -> {
            if (currentCircle < 4) {
                currentCircle++;
                init();
            }
        }).dimensions(centerX + 30, centerY - 10, 30, 20).build());
        
        // Spell buttons in circle
        int spellStart = currentCircle * 10 + 1;
        double radius = 80;
        for (int i = 0; i < 10; i++) {
            int spellId = spellStart + i;
            if (spellId <= 50) {
                SpellRegistry.Spell spell = SpellRegistry.SPELLS.get(spellId);
                if (spell != null) {
                    PlayerDataManager.PlayerData data = PlayerDataManager.getData(player);
                    boolean learned = data.learnedSpells.contains(spellId);
                    
                    double angle = (i * 36 - 90) * Math.PI / 180;
                    int x = (int)(centerX + radius * Math.cos(angle)) - 40;
                    int y = (int)(centerY + radius * Math.sin(angle)) - 10;
                    
                    String display = learned ? spell.name.substring(0, Math.min(6, spell.name.length())) : "???";
                    
                    buttons.add(ButtonWidget.builder(Text.literal(display), btn -> {
                        if (learned) {
                            data.activeSpell = spellId;
                            close();
                        }
                    }).dimensions(x, y, 80, 20).build());
                }
            }
        }
        
        for (ButtonWidget button : buttons) {
            addDrawableChild(button);
        }
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, 0, 0, width, height, 0x80000000);
        
        int centerX = width / 2;
        int centerY = height / 2;
        
        // Draw circle outline
        context.drawCircle(centerX, centerY, 90, 0x40FFFFFF);
        
        super.render(context, mouseX, mouseY, delta);
        
        // Auto-close after 10 seconds
        if (System.currentTimeMillis() > closeTime) {
            close();
        }
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
}
