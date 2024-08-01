package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private Map<String, Skill> skills;

    public SkillManager() {
        this.skills = new HashMap<>();
    }

    public void registerSkill(Skill skill) {
        skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String name) {
        return skills.get(name);
    }

    public void learnSkill(Player player, Skill skill) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.learnSkill(skill);
    }

    public void useSkill(Player player, Skill skill) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        if (playerData.hasSkill(skill)) {
            skill.use(player);
        }
    }
}

public class Skill {
    private String name;
    private String description;
    private int cooldown;
    private SkillEffect effect;

    public Skill(String name, String description, int cooldown, SkillEffect effect) {
        this.name = name;
        this.description = description;
        this.cooldown = cooldown;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void use(Player player) {
        effect.apply(player);
    }
}

public interface SkillEffect {
    void apply(Player player);
}
