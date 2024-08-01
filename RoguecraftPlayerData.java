package com.example.roguecraftplugin;

import org.bukkit.entity.Player;

public class RoguecraftPlayerData {
    private Player player;
    private int level;
    private int skillPoints;
    private RoguecraftClass playerClass;
    private RoguecraftSpecialization specialization;
    private Map<Ability, Integer> abilityLevels;
    private Map<ItemType, Item> equippedItems;

    public RoguecraftPlayerData(Player player) {
        this.player = player;
        this.level = 1;
        this.skillPoints = 0;
        this.playerClass = RoguecraftClass.WARRIOR;
        this.specialization = RoguecraftSpecialization.SWORD_AND_SHIELD;
        this.abilityLevels = new HashMap<>();
    }

    public RoguecraftPlayerData(Player player) {
        // ... existing code ...
        this.equippedItems = new HashMap<>();
    }

    public void equipItem(Item item) {
        equippedItems.put(item.getType(), item);
        // Update player stats based on the equipped item
    }

    public Item getEquippedItem(ItemType type) {
        return equippedItems.get(type);
    }

    public void learnAbility(Ability ability) {
        abilityLevels.put(ability, 1);
    }

    public void upgradeAbility(Ability ability) {
        int currentLevel = abilityLevels.getOrDefault(ability, 0);
        if (currentLevel < ability.getMaxLevel()) {
            abilityLevels.put(ability, currentLevel + 1);
            // Notify the player of the ability upgrade
        }
    }
}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public RoguecraftClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(RoguecraftClass playerClass) {
        this.playerClass = playerClass;
    }

    public RoguecraftSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(RoguecraftSpecialization specialization) {
        this.specialization = specialization;
    }

    public int getAbilityLevel(Ability ability) {
        return abilityLevels.getOrDefault(ability, 0);
    }

    public void setAbilityLevel(Ability ability, int level) {
        abilityLevels.put(ability, level);
    }
}
