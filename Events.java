package com.example.roguecraftplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class RoguecraftEventHandler implements Listener {
    private RoguecraftPlugin plugin;
    private CombatManager combatManager;

    public RoguecraftEventHandler(RoguecraftPlugin plugin, CombatManager combatManager) {
        this.plugin = plugin;
        this.combatManager = combatManager;
    }

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
            Player player = (Player) event.getDamager();
            LivingEntity target = (LivingEntity) event.getEntity();
            combatManager.handlePlayerAttack(player, target);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);

        // Check if the player is using an ability
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            String usedAbility = getUsedAbility(event);
            if (usedAbility != null) {
                Ability ability = playerData.getAbility(usedAbility);
                if (ability != null) {
                    playerData.upgradeAbility(ability);
                    // Activate the ability and apply its effects
                    activateAbility(player, ability);
                }
            }
        }
    }

    private String getUsedAbility(PlayerInteractEvent event) {
        // Implement logic to determine which ability the player is using based on the interaction event
        return "Cleave";
    }

    private void activateAbility(Player player, Ability ability) {
        // Implement logic to activate the specified ability and apply its effects
    }
}
