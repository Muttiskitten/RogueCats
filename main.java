package com.example.roguecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class RoguecraftPlugin extends JavaPlugin {
    private Map<Player, RoguecraftPlayerData> playerData;
    private SkillManager skillManager;
    private CombatManager combatManager;

    @Override
    public void onEnable() {
        playerData = new HashMap<>();
        skillManager = new SkillManager(this);
        combatManager = new CombatManager(this);

        // Register skills
        Skill fireball = new Skill("Fireball", "Shoot a fireball at your enemies", 10000, new FireballSkillEffect());
        skillManager.registerSkill(fireball);

        RoguecraftEventListener eventListener = new RoguecraftEventListener(this, combatManager);
        Bukkit.getPluginManager().registerEvents(eventListener, this);

        // Load player data from storage or create new data
        for (Player player : Bukkit.getOnlinePlayers()) {
            getPlayerData(player);
        }
    }

    @Override
    public void onDisable() {
        // Save player data to storage
        for (Map.Entry<Player, RoguecraftPlayerData> entry : playerData.entrySet()) {
            savePlayerData(entry.getKey(), entry.getValue());
        }
    }

    public RoguecraftPlayerData getPlayerData(Player player) {
        RoguecraftPlayerData data = playerData.get(player);
        if (data == null) {
            data = new RoguecraftPlayerData(player);
            playerData.put(player, data);
        }
        return data;
    }

    private void savePlayerData(Player player, RoguecraftPlayerData data) {
        // Implement logic to save player data to storage
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }
}
