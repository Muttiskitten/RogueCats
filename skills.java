package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private RoguecraftPlugin plugin;

    public SkillManager(RoguecraftPlugin plugin) {
        this.plugin = plugin;
    }

    public void learnSkill(Player player, Skill skill) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.learnSkill(skill);
    }

    public void upgradeSkill(Player player, Skill skill) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.upgradeSkill(skill);
    }

    public Map<Skill, Integer> getPlayerSkills(Player player) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        return playerData.getSkillLevels();
    }
}

public class Skill {
    private String name;
    private String description;
    private Map<Stat, Integer> statRequirements;
    private Map<Stat, Integer> statBonuses;

    public Skill(String name, String description, Map<Stat, Integer> statRequirements, Map<Stat, Integer> statBonuses) {
        this.name = name;
        this.description = description;
        this.statRequirements = statRequirements;
        this.statBonuses = statBonuses;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<Stat, Integer> getStatRequirements() {
        return statRequirements;
    }

    public Map<Stat, Integer> getStatBonuses() {
        return statBonuses;
    }
}
