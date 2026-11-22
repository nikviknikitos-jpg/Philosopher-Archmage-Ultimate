package com.example.ritual;

import java.util.*;

public class FamiliarRegistry {
    public static final Map<String, FamiliarType> FAMILIARS = new HashMap<>();
    
    public static void init() {
        FAMILIARS.put("phoenix", new FamiliarType("phoenix", 20, 5, Arrays.asList("fire_resistance", "fire_attack")));
        FAMILIARS.put("owl", new FamiliarType("owl", 15, 3, Arrays.asList("night_vision", "entity_highlight")));
        FAMILIARS.put("spirit", new FamiliarType("spirit", 18, 4, Arrays.asList("mana_regen", "resistance")));
    }
    
    public static class FamiliarType {
        public final String name;
        public final int health;
        public final int damage;
        public final List<String> abilities;
        
        public FamiliarType(String name, int health, int damage, List<String> abilities) {
            this.name = name;
            this.health = health;
            this.damage = damage;
            this.abilities = abilities;
        }
    }
}
