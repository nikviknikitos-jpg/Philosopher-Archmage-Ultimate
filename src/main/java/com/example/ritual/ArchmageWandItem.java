package com.example.ritual;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ArchmageWandItem extends Item {
    public ArchmageWandItem() {
        super(new Settings().maxCount(1));
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        PlayerDataManager.PlayerData data = PlayerDataManager.getData(user);
        if (data.activeSpell >= 0 && data.mana >= 10) {
            SpellRegistry.Spell spell = SpellRegistry.SPELLS.get(data.activeSpell);
            if (spell != null) {
                int cost = spell.getActualManaCost(data);
                if (data.mana >= cost) {
                    data.mana -= cost;
                    // Cast spell logic would go here
                    return TypedActionResult.consume(user.getStackInHand(hand));
                }
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
