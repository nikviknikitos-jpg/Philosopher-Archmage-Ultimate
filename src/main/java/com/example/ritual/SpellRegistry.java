package com.example.ritual;

import java.util.*;

public class SpellRegistry {
    public static final Map<Integer, Spell> SPELLS = new HashMap<>();
    
    public static void init() {
        // Tome I - Fire
        registerSpell(1, "Fireball", 10, Arrays.asList(2, 2));
        registerSpell(2, "Flame Ring", 15, Arrays.asList(3, 3));
        registerSpell(3, "Fire Beam", 20, Arrays.asList(4, 4));
        registerSpell(4, "Meteor Shower", 35, Arrays.asList(5, 5));
        registerSpell(5, "Fire Dash", 12, Arrays.asList(2, 3));
        
        // Tome II - Ice
        registerSpell(6, "Ice Spear", 10, Arrays.asList(2, 2));
        registerSpell(7, "Freeze", 18, Arrays.asList(3, 4));
        registerSpell(8, "Ice Shield", 15, Arrays.asList(3, 3));
        registerSpell(9, "Snow Storm", 30, Arrays.asList(5, 5));
        registerSpell(10, "Ice Cage", 20, Arrays.asList(4, 4));
        
        // Tome III - Lightning
        registerSpell(11, "Lightning Strike", 12, Arrays.asList(2, 3));
        registerSpell(12, "Chain Lightning", 25, Arrays.asList(4, 5));
        registerSpell(13, "Thunder Pulse", 15, Arrays.asList(3, 3));
        registerSpell(14, "Wind Speed", 10, Arrays.asList(2, 2));
        registerSpell(15, "Thunder Storm", 35, Arrays.asList(5, 6));
        
        // Tome IV - Light
        registerSpell(16, "Heal", 20, Arrays.asList(3, 4));
        registerSpell(17, "Light Dome", 25, Arrays.asList(4, 5));
        registerSpell(18, "Blinding Flash", 15, Arrays.asList(3, 3));
        registerSpell(19, "Purify", 18, Arrays.asList(3, 4));
        registerSpell(20, "Solar Explosion", 30, Arrays.asList(5, 5));
        
        // Tome V - Shadow & Blood
        registerSpell(21, "Wither Arrow", 12, Arrays.asList(2, 3));
        registerSpell(22, "Vampirism", 20, Arrays.asList(4, 4));
        registerSpell(23, "Shadow Invisibility", 25, Arrays.asList(4, 5));
        registerSpell(24, "Weakness Ring", 15, Arrays.asList(3, 3));
        registerSpell(25, "Dark Vortex", 30, Arrays.asList(5, 5));
        
        // Tome VI - Earth
        registerSpell(26, "Stone Wall", 15, Arrays.asList(3, 3));
        registerSpell(27, "Earthquake", 25, Arrays.asList(4, 5));
        registerSpell(28, "Ore Sense", 10, Arrays.asList(2, 2));
        registerSpell(29, "Iron Skin", 18, Arrays.asList(3, 4));
        registerSpell(30, "Instant Drill", 20, Arrays.asList(4, 4));
        
        // Tome VII - Wind & Sky
        registerSpell(31, "Wind Gust", 12, Arrays.asList(2, 3));
        registerSpell(32, "Slow Fall", 8, Arrays.asList(2, 2));
        registerSpell(33, "Air Bridge", 20, Arrays.asList(4, 4));
        registerSpell(34, "Hurricane", 35, Arrays.asList(5, 6));
        registerSpell(35, "Seraphim Flight", 30, Arrays.asList(5, 5));
        
        // Tome VIII - Space
        registerSpell(36, "Short Teleport", 15, Arrays.asList(3, 3));
        registerSpell(37, "Long Jump", 25, Arrays.asList(4, 5));
        registerSpell(38, "Gravity Funnel", 20, Arrays.asList(4, 4));
        registerSpell(39, "Magnet Pickup", 12, Arrays.asList(2, 3));
        registerSpell(40, "Return Spawn", 18, Arrays.asList(3, 4));
        
        // Tome IX - Summoning & Nature
        registerSpell(41, "Summon Guardian", 30, Arrays.asList(5, 5));
        registerSpell(42, "Summon Fire Spirit", 25, Arrays.asList(4, 5));
        registerSpell(43, "Plant Growth", 15, Arrays.asList(3, 3));
        registerSpell(44, "Firefly Swarm", 12, Arrays.asList(2, 3));
        registerSpell(45, "Repair Equipment", 20, Arrays.asList(4, 4));
        
        // Tome X - Higher Arcana
        registerSpell(46, "Stone Transmutation", 35, Arrays.asList(5, 6));
        registerSpell(47, "Nova Star", 40, Arrays.asList(6, 7));
        registerSpell(48, "Immortality Elixir", 50, Arrays.asList(7, 8));
        registerSpell(49, "Dawn Summon", 45, Arrays.asList(6, 7));
        registerSpell(50, "Architect Judgment", 60, Arrays.asList(8, 10));
    }
    
    private static void registerSpell(int id, String name, int baseMana, List<Integer> cost) {
        SPELLS.put(id, new Spell(id, name, baseMana, cost));
    }
    
    public static class Spell {
        public final int id;
        public final String name;
        public final int baseManaCost;
        public final List<Integer> learningCost;
        
        public Spell(int id, String name, int baseManaCost, List<Integer> learningCost) {
            this.id = id;
            this.name = name;
            this.baseManaCost = baseManaCost;
            this.learningCost = learningCost;
        }
        
        public int getActualManaCost(PlayerDataManager.PlayerData data) {
            return (int)(baseManaCost * data.getManaCostMultiplier());
        }
    }
}
