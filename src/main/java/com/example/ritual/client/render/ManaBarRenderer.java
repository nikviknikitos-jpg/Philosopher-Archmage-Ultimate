package com.example.ritual.client.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import com.example.ritual.PlayerDataManager;

public class ManaBarRenderer {
    public static void render(DrawContext context, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        
        if (player == null) return;
        
        PlayerDataManager.PlayerData data = PlayerDataManager.getData(player);
        
        int barWidth = 182;
        int barHeight = 5;
        int x = (client.getWindow().getScaledWidth() - barWidth) / 2;
        int y = client.getWindow().getScaledHeight() - 45;
        
        // Background
        context.fill(x, y, x + barWidth, y + barHeight, 0xFF404040);
        
        // Mana fill
        int manaFill = (int)((float)data.mana / data.getMaxMana() * barWidth);
        context.fill(x, y, x + manaFill, y + barHeight, 0xFFFFD700);
        
        // Border
        context.drawBorder(x - 1, y - 1, barWidth + 2, barHeight + 2, 0xFFFFFFFF);
    }
}
