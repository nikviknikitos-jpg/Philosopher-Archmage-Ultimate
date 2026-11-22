package com.example.ritual.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.example.ritual.RitualMod;

public class BlackPedestalBlock extends Block {
    public static final BlockEntityType<BlackPedestalBlockEntity> BLOCK_ENTITY_TYPE = 
        Registry.register(Registries.BLOCK_ENTITY_TYPE, 
            new Identifier(RitualMod.MOD_ID, "black_pedestal"),
            BlockEntityType.Builder.create(BlackPedestalBlockEntity::new, null).build(null));
    
    public BlackPedestalBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }
}
