package com.example.ritual.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

public class WhitePedestalBlock extends Block {
    public static final BlockEntityType<WhitePedestalBlockEntity> BLOCK_ENTITY_TYPE = 
        Registry.register(Registries.BLOCK_ENTITY_TYPE, 
            new Identifier(RitualMod.MOD_ID, "white_pedestal"),
            BlockEntityType.Builder.create(WhitePedestalBlockEntity::new, com.example.ritual.RitualMod.WHITE_PEDESTAL).build(null));
    
    public WhitePedestalBlock(Settings settings) {
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
