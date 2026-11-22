package com.example.ritual.blocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

public class BlackPedestalBlockEntity extends BlockEntity {
    private ItemStack heldItem = ItemStack.EMPTY;
    private float rotation = 0;
    
    public BlackPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(BlackPedestalBlock.BLOCK_ENTITY_TYPE, pos, state);
    }
    
    public ItemStack getHeldItem() {
        return heldItem;
    }
    
    public void setHeldItem(ItemStack item) {
        this.heldItem = item;
    }
    
    public float getRotation() {
        return rotation;
    }
    
    public void tick() {
        rotation += 2.0f;
        if (rotation >= 360) {
            rotation -= 360;
        }
    }
}
