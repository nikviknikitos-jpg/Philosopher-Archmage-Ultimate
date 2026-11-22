package com.example.ritual;

import com.example.ritual.blocks.BlackPedestalBlock;
import com.example.ritual.blocks.WhitePedestalBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class RitualMod implements ModInitializer {
    public static final String MOD_ID = "ritual";

    // Blocks
    public static final Block WHITE_PEDESTAL = new WhitePedestalBlock(
            AbstractBlock.Settings.create().strength(2.0f).sounds(BlockSoundGroup.STONE).nonOpaque()
    );
    public static final Block BLACK_PEDESTAL = new BlackPedestalBlock(
            AbstractBlock.Settings.create().strength(2.0f).sounds(BlockSoundGroup.STONE).nonOpaque()
    );

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
        // Register blocks and block items
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "white_pedestal"), WHITE_PEDESTAL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "white_pedestal"), new BlockItem(WHITE_PEDESTAL, new Item.Settings()));

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "black_pedestal"), BLACK_PEDESTAL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "black_pedestal"), new BlockItem(BLACK_PEDESTAL, new Item.Settings()));

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
