package com.example.ritual.client.render;

import com.example.ritual.blocks.WhitePedestalBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class WhitePedestalRenderer implements BlockEntityRenderer<WhitePedestalBlockEntity> {
    private final ItemRenderer itemRenderer;
    
    public WhitePedestalRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }
    
    @Override
    public void render(WhitePedestalBlockEntity entity, float tickDelta, MatrixStack matrices, 
                      VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack item = entity.getHeldItem();
        if (!item.isEmpty()) {
            matrices.push();
            matrices.translate(0.5, 1.25, 0.5);
            float rotation = entity.getRotation() + tickDelta * 2.0f;
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            matrices.scale(0.75f, 0.75f, 0.75f);
            itemRenderer.renderItem(item, net.minecraft.client.render.model.ModelTransformationMode.FIXED, 
                                   light, overlay, matrices, vertexConsumers, null, 0);
            matrices.pop();
        }
    }
}
