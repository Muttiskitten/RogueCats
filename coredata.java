package com.example.roguecraftplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class RoguecraftPlugin extends JavaPlugin implements Listener {
    private Map<Player, RoguecraftPlayerData> playerDataMap;

    @Override
    public void onEnable() {
        // Initialize the player data map
        playerDataMap = new HashMap<>();

        // Register event listeners
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Create new player data when a player joins
        RoguecraftPlayerData playerData = new RoguecraftPlayerData(player);
        playerDataMap.put(player, playerData);
    }

    public RoguecraftPlayerData getPlayerData(Player player) {
        return playerDataMap.get(player);
    }
}
