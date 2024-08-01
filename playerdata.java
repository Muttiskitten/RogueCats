package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class RoguecraftPlayerData {
    private Player player;
    private Map<Skill, Boolean> learnedSkills;
    private Map<Skill, Long> skillCooldowns;

    public RoguecraftPlayerData(Player player) {
        this.player = player;
        this.learnedSkills = new HashMap<>();
        this.skillCooldowns = new HashMap<>();
    }

    public void learnSkill(Skill skill) {
        learnedSkills.put(skill, true);
    }

    public boolean hasSkill(Skill skill) {
        return learnedSkills.getOrDefault(skill, false);
    }

    public boolean isOnCooldown(Skill skill) {
        long cooldownExpiration = skillCooldowns.getOrDefault(skill, 0L);
        return cooldownExpiration > System.currentTimeMillis();
    }

    public void startCooldown(Skill skill) {
        skillCooldowns.put(skill, System.currentTimeMillis() + skill.getCooldown());
    }
}
