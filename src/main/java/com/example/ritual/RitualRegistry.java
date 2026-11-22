package com.example.ritual;

import java.util.*;

public class RitualRegistry {
    public static final Map<Integer, Ritual> RITUALS = new HashMap<>();
    
    public static void init() {
        // Category 1: Solar Enchantments
        registerRitual(1, "Solar Weapon Enchantment", 
            Arrays.asList("diamond_sword", "gold_ingot", "gold_ingot"),
            "enchanted_diamond_sword",
            "Enchants weapon with solar power");
        
        registerRitual(2, "Solar Armor Enchantment",
            Arrays.asList("diamond_chestplate", "gold_ingot", "gold_ingot", "gold_ingot"),
            "enchanted_diamond_chestplate",
            "Enchants armor with solar protection");
        
        registerRitual(3, "Solar Tool Enchantment",
            Arrays.asList("diamond_pickaxe", "gold_ingot", "gold_ingot"),
            "enchanted_diamond_pickaxe",
            "Enchants tool with solar efficiency");
        
        registerRitual(4, "Solar Bow Enchantment",
            Arrays.asList("bow", "gold_ingot", "gold_ingot", "string"),
            "enchanted_bow",
            "Enchants bow with solar arrows");
        
        registerRitual(5, "Solar Shield Enchantment",
            Arrays.asList("shield", "gold_ingot", "gold_ingot"),
            "enchanted_shield",
            "Enchants shield with solar barrier");
        
        // Category 2: Alchemical Transmutation
        registerRitual(6, "Gold Transmutation",
            Arrays.asList("iron_block", "redstone", "glowstone_dust"),
            "gold_block",
            "Transmutes iron into gold");
        
        registerRitual(7, "Diamond Creation",
            Arrays.asList("coal_block", "coal_block", "coal_block", "lapis_lazuli"),
            "diamond",
            "Creates diamond from coal");
        
        registerRitual(8, "Emerald Synthesis",
            Arrays.asList("prismarine_crystals", "lime_dye", "experience_bottle"),
            "emerald",
            "Synthesizes emerald");
        
        registerRitual(9, "Netherite Infusion",
            Arrays.asList("diamond_block", "netherite_scrap", "netherite_scrap", "netherite_scrap"),
            "netherite_ingot",
            "Infuses diamond with netherite");
        
        registerRitual(10, "Ancient Debris Recovery",
            Arrays.asList("obsidian", "netherrack", "netherrack", "netherrack"),
            "ancient_debris",
            "Recovers ancient debris");
        
        // Category 3: Solar Weapons & Tools
        registerRitual(11, "Dawn Blade Creation",
            Arrays.asList("diamond_sword", "sunflower", "gold_block"),
            "dawn_blade",
            "Creates the legendary Dawn Blade");
        
        registerRitual(12, "Sun Pickaxe Creation",
            Arrays.asList("diamond_pickaxe", "sunflower", "gold_block"),
            "sun_pickaxe",
            "Creates the Sun Pickaxe with 3x3 mining");
        
        registerRitual(13, "Lumberjack Axe",
            Arrays.asList("diamond_axe", "oak_log", "oak_log", "vine"),
            "enchanted_diamond_axe",
            "Creates axe that cuts entire trees");
        
        registerRitual(14, "Apollo Bow",
            Arrays.asList("bow", "golden_apple", "sunflower"),
            "enchanted_bow",
            "Creates Apollo's legendary bow");
        
        registerRitual(15, "Dawn Shield",
            Arrays.asList("shield", "gold_block", "sunflower"),
            "enchanted_shield",
            "Creates shield of dawn light");
        
        // Category 4: Elixirs & Artifacts
        registerRitual(16, "Immortality Elixir",
            Arrays.asList("golden_apple", "nether_star", "dragon_breath", "ghast_tear"),
            "potion",
            "Creates elixir of immortality");
        
        registerRitual(17, "Seraphim Amulet",
            Arrays.asList("diamond", "feather", "feather", "feather", "gold_ingot"),
            "amulet_of_seraphim",
            "Creates amulet granting flight");
        
        registerRitual(18, "Magnet Ring",
            Arrays.asList("gold_ingot", "redstone", "compass"),
            "magnet_ring",
            "Creates ring that attracts items");
        
        registerRitual(19, "Eternal Day Sphere",
            Arrays.asList("glowstone", "sea_lantern", "beacon"),
            "eternal_day_sphere",
            "Creates sphere of eternal daylight");
        
        registerRitual(20, "Immortality Totem",
            Arrays.asList("totem_of_undying", "nether_star", "golden_apple"),
            "enhanced_totem",
            "Enhances totem of undying");
        
        // Category 5: Archmage Items
        registerRitual(21, "Archmage Wand Creation",
            Arrays.asList("stick", "diamond", "ender_eye", "blaze_rod"),
            "archmage_wand",
            "Creates the Archmage Wand");
        
        registerRitual(22, "Magic Tome Creation",
            Arrays.asList("book", "lapis_lazuli", "glowstone_dust"),
            "spell_tome_1",
            "Creates a spell tome");
        
        registerRitual(23, "Beacon Enhancement",
            Arrays.asList("beacon", "nether_star", "diamond_block"),
            "enhanced_beacon",
            "Enhances beacon range");
        
        registerRitual(24, "Accumulation Obelisk",
            Arrays.asList("obsidian", "obsidian", "obsidian", "beacon"),
            "accumulation_obelisk",
            "Creates mana accumulation obelisk");
        
        registerRitual(25, "Philosopher Stone Recharge",
            Arrays.asList("philosophers_stone", "gold_block", "diamond_block"),
            "philosophers_stone",
            "Recharges philosopher stone");
        
        // Category 6: Familiars & Guardians
        registerRitual(26, "Phoenix Familiar Summon",
            Arrays.asList("phoenix_orb", "blaze_powder", "magma_cream", "fire_charge"),
            "phoenix_familiar",
            "Summons Phoenix familiar");
        
        registerRitual(27, "Owl Familiar Summon",
            Arrays.asList("owl_orb", "feather", "spider_eye", "ink_sac"),
            "owl_familiar",
            "Summons Owl familiar");
        
        registerRitual(28, "Spirit Familiar Summon",
            Arrays.asList("spirit_orb", "diamond", "ender_pearl", "experience_bottle"),
            "spirit_familiar",
            "Summons Crystal Spirit familiar");
        
        registerRitual(29, "Solar Guardian Summon",
            Arrays.asList("gold_block", "sunflower", "blaze_rod", "ghast_tear"),
            "solar_guardian",
            "Summons Solar Guardian");
        
        registerRitual(30, "Familiar Bond Enhancement",
            Arrays.asList("phoenix_orb", "owl_orb", "spirit_orb", "nether_star"),
            "enhanced_familiar_bond",
            "Enhances all familiar bonds");
    }
    
    private static void registerRitual(int id, String name, List<String> ingredients, String result, String description) {
        RITUALS.put(id, new Ritual(id, name, ingredients, result, description));
    }
    
    public static class Ritual {
        public final int id;
        public final String name;
        public final List<String> ingredients;
        public final String result;
        public final String description;
        
        public Ritual(int id, String name, List<String> ingredients, String result, String description) {
            this.id = id;
            this.name = name;
            this.ingredients = ingredients;
            this.result = result;
            this.description = description;
        }
    }
}
