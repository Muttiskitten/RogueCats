package com.example.roguecraftplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class RoguecraftPlugin extends JavaPlugin {
    private SkillManager skillManager;
    private Map<Player, RoguecraftPlayerData> playerData;

    @Override
    public void onEnable() {
        this.skillManager = new SkillManager();
        this.playerData = new HashMap<>();

        // Register skills
        Skill fireball = new Skill("Fireball", "Shoot a fireball at your enemies", 10000, new FireballSkillEffect());
        skillManager.registerSkill(fireball);

        // Register event listener
        getServer().getPluginManager().registerEvents(new RoguecraftEventListener(this), this);
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public RoguecraftPlayerData getPlayerData(Player player) {
        return playerData.computeIfAbsent(player, RoguecraftPlayerData::new);
    }
}
