package com.example.ritual.client.screens;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.DrawContext;
import com.example.ritual.RitualRegistry;
import java.util.ArrayList;
import java.util.List;

public class AlchemyCodexScreen extends Screen {
    private int currentPage = 0;
    private int totalPages = 7; // 0 = index, 1-6 = ritual categories
    private List<ButtonWidget> buttons = new ArrayList<>();
    
    public AlchemyCodexScreen() {
        super(Text.literal("Alchemy Codex"));
    }
    
    @Override
    protected void init() {
        buttons.clear();
        int centerX = width / 2;
        int centerY = height / 2;
        int top = centerY - 95;
        int left = centerX - 128;
        
        // Navigation buttons at bottom
        buttons.add(ButtonWidget.builder(Text.literal("Index"), btn -> {
            currentPage = 0;
            init();
        }).dimensions(left + 20, top + 195, 60, 20).build());
        
        buttons.add(ButtonWidget.builder(Text.literal("< Back"), btn -> {
            if (currentPage > 0) {
                currentPage--;
                init();
            }
        }).dimensions(left + 90, top + 195, 60, 20).build());
        
        buttons.add(ButtonWidget.builder(Text.literal("Forward >"), btn -> {
            if (currentPage < totalPages - 1) {
                currentPage++;
                init();
            }
        }).dimensions(left + 160, top + 195, 70, 20).build());
        
        if (currentPage == 0) {
            // Index page - 6 category buttons
            String[] categories = {"Solar Enchantments", "Alchemical Transmutation", 
                                  "Solar Weapons & Tools", "Elixirs & Artifacts",
                                  "Archmage Items", "Familiars & Guardians"};
            for (int i = 0; i < 6; i++) {
                int row = i / 2;
                int col = i % 2;
                buttons.add(ButtonWidget.builder(Text.literal(categories[i]), btn -> {
                    currentPage = i + 1;
                    init();
                }).dimensions(left + 20 + col * 130, top + 30 + row * 30, 120, 25).build());
            }
        } else {
            // Ritual page
            int categoryStart = (currentPage - 1) * 5 + 1;
            for (int i = 0; i < 5; i++) {
                int ritualId = categoryStart + i;
                if (ritualId <= 30) {
                    RitualRegistry.Ritual ritual = RitualRegistry.RITUALS.get(ritualId);
                    if (ritual != null) {
                        buttons.add(ButtonWidget.builder(Text.literal(" Show"), btn -> {
                            // Enable ritual highlighting
                        }).dimensions(left + 180, top + 20 + i * 28, 60, 20).build());
                    }
                }
            }
        }
        
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
        
        // Draw book background
        context.fill(left, top, left + 256, top + 190, 0xFF202020);
        context.drawBorder(left, top, 256, 190, 0xFF808080);
        
        if (currentPage == 0) {
            context.drawTextWithShadow(textRenderer, Text.literal("Alchemy Codex - Index"), 
                                     centerX - 50, top + 11, 0xFFFFFF);
        } else {
            int categoryStart = (currentPage - 1) * 5 + 1;
            context.drawTextWithShadow(textRenderer, 
                                     Text.literal("Category " + currentPage), 
                                     centerX - 40, top + 11, 0xFFFFFF);
            
            // Display rituals
            for (int i = 0; i < 5; i++) {
                int ritualId = categoryStart + i;
                if (ritualId <= 30) {
                    RitualRegistry.Ritual ritual = RitualRegistry.RITUALS.get(ritualId);
                    if (ritual != null) {
                        context.drawTextWithShadow(textRenderer, 
                                                 Text.literal(ritual.name), 
                                                 left + 20, top + 25 + i * 28, 0xFFFFAA);
                    }
                }
            }
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
