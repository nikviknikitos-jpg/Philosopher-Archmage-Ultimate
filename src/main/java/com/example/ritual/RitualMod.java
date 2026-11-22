package com.example.ritual;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.text.Text;
import net.minecraft.item.ItemStack;

public class RitualMod implements ModInitializer {
    public static final String MOD_ID = "ritual";
    
    // Items
    public static final Item PHILOSOPHERS_STONE = new PhilosophersStoneItem();
    public static final Item ALCHEMY_CODEX = new AlchemyCodexItem();
    public static final Item ARCHMAGE_WAND = new ArchmageWandItem();
    public static final Item DAWN_BLADE = new DawnBladeItem();
    public static final Item SUN_PICKAXE = new SunPickaxeItem();
    
    public static final Item[] SPELL_TOMES = new Item[10];
    public static final Item PHOENIX_ORB = new PhoenixOrbItem();
    public static final Item OWL_ORB = new OwlOrbItem();
    public static final Item SPIRIT_ORB = new SpiritOrbItem();
    
    @Override
    public void onInitialize() {
        // Register items
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "philosophers_stone"), PHILOSOPHERS_STONE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "alchemy_codex"), ALCHEMY_CODEX);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "archmage_wand"), ARCHMAGE_WAND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dawn_blade"), DAWN_BLADE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sun_pickaxe"), SUN_PICKAXE);
        
        for (int i = 0; i < 10; i++) {
            SPELL_TOMES[i] = new SpellTomeItem(i + 1);
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spell_tome_" + (i + 1)), SPELL_TOMES[i]);
        }
        
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "phoenix_orb"), PHOENIX_ORB);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "owl_orb"), OWL_ORB);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spirit_orb"), SPIRIT_ORB);
        
        // Initialize registries
        SpellRegistry.init();
        RitualRegistry.init();
        FamiliarRegistry.init();
        
        System.out.println("Ritual Mod initialized!");
    }
}
