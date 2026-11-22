package com.example.ritual;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class SpellTomeItem extends Item {
    private final int tomeNumber;
    
    public SpellTomeItem(int tomeNumber) {
        super(new Settings().maxCount(1));
        this.tomeNumber = tomeNumber;
    }
    
    public int getTomeNumber() {
        return tomeNumber;
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
