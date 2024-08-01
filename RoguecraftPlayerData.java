package com.example.roguecraftplugin;

import org.bukkit.entity.Player;

public class RoguecraftPlayerData {
    private Player player;
    private int level;
    private int skillPoints;
    private RoguecraftClass playerClass;
    private RoguecraftSpecialization specialization;
    private Map<Ability, Integer> abilityLevels;

    public RoguecraftPlayerData(Player player) {
        this.player = player;
        this.level = 1;
        this.skillPoints = 0;
        this.playerClass = RoguecraftClass.WARRIOR;
        this.specialization = RoguecraftSpecialization.SWORD_AND_SHIELD;
        this.abilityLevels = new HashMap<>();
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
