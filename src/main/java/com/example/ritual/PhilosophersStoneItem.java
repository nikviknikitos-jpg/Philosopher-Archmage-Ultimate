package com.example.ritual;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class PhilosophersStoneItem extends Item {
    public PhilosophersStoneItem() {
        super(new Settings().maxCount(1));
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
    
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }
    
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
