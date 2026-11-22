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

public class SpellTomeScreen extends Screen {
    private final int tomeNumber;
    private List<ButtonWidget> buttons = new ArrayList<>();
    private PlayerEntity player;
    
    public SpellTomeScreen(int tomeNumber) {
        super(Text.literal("Spell Tome " + tomeNumber));
        this.tomeNumber = tomeNumber;
    }
    
    @Override
    protected void init() {
        buttons.clear();
        MinecraftClient client = MinecraftClient.getInstance();
        player = client.player;
        
        if (player == null) return;
        
        int centerX = width / 2;
        int centerY = height / 2;
        int top = centerY - 95;
        int left = centerX - 128;
        
        int spellStart = (tomeNumber - 1) * 5 + 1;
        
        for (int i = 0; i < 5; i++) {
            int spellId = spellStart + i;
            if (spellId <= 50) {
                SpellRegistry.Spell spell = SpellRegistry.SPELLS.get(spellId);
                if (spell != null) {
                    PlayerDataManager.PlayerData data = PlayerDataManager.getData(player);
                    boolean learned = data.learnedSpells.contains(spellId);
                    
                    String buttonText = learned ? "[LEARNED] " + spell.name : 
                                       "Learn: " + spell.name + " (" + spell.learningCost.get(0) + " XP)";
                    
                    int yPos = top + 30 + i * 30;
                    buttons.add(ButtonWidget.builder(Text.literal(buttonText), btn -> {
                        if (!learned) {
                            // Send learn packet to server
                        }
                    }).dimensions(left + 20, yPos, 200, 25).build());
                }
            }
        }
        
        buttons.add(ButtonWidget.builder(Text.literal("Close"), btn -> {
            close();
        }).dimensions(centerX - 40, top + 195, 80, 20).build());
        
        for (ButtonWidget button : buttons) {
            addDrawableChild(button);
        }
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        
        int centerX = width / 2;
        int centerY = height / 2;
        int top = centerY - 95;
        int left = centerX - 128;
        
        context.fill(left, top, left + 256, top + 190, 0xFF202020);
        context.drawBorder(left, top, 256, 190, 0xFF808080);
        
        context.drawTextWithShadow(textRenderer, 
                                 Text.literal("Spell Tome " + tomeNumber), 
                                 centerX - 50, top + 11, 0xFFFFFF);
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
