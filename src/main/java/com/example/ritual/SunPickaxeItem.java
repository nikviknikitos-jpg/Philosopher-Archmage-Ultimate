package com.example.ritual;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;

public class SunPickaxeItem extends PickaxeItem {
    public SunPickaxeItem() {
        super(ToolMaterials.DIAMOND, 1, -2.8f, new Settings());
    }
}
