package com.example.ritual;

import net.minecraft.entity.player.PlayerEntity;
import java.util.*;

public class PlayerDataManager {
    private static final Map<UUID, PlayerData> playerDataMap = new HashMap<>();
    
    public static PlayerData getData(PlayerEntity player) {
        UUID uuid = player.getUuid();
        if (!playerDataMap.containsKey(uuid)) {
            playerDataMap.put(uuid, new PlayerData());
        }
        return playerDataMap.get(uuid);
    }
    
    public static class PlayerData {
        public int mana = 100;
        public int maxMana = 100;
        public int manaRegenRate = 1;
        public Set<Integer> learnedSpells = new HashSet<>();
        public Map<Integer, Integer> skillLevels = new HashMap<>();
        public boolean[] ritualHighlights = new boolean[30];
        public int highlightTimer = 0;
        public int activeSpell = -1;
        public Map<Integer, Integer> learningProgress = new HashMap<>();
        
        public PlayerData() {
            for (int i = 0; i < 6; i++) {
                skillLevels.put(i, 0);
            }
        }
        
        public int getSkillLevel(int skillId) {
            return skillLevels.getOrDefault(skillId, 0);
        }
        
        public void setSkillLevel(int skillId, int level) {
            skillLevels.put(skillId, Math.min(level, 3));
        }
        
        public float getManaCostMultiplier() {
            int level = getSkillLevel(3); // Mana Efficiency
            return 1.0f - (level * 0.15f);
        }
        
        public int getLearningTimeReduction() {
            int level = getSkillLevel(2); // Fast Reading
            return level * 20; // Reduce by 20 ticks per level
        }
        
        public int getMaxMana() {
            int level = getSkillLevel(0); // Ether Source
            return 100 + (level * 50);
        }
        
        public int getManaRegenRate() {
            int level = getSkillLevel(1); // Solar Flow
            return 1 + level;
        }
    }
}
