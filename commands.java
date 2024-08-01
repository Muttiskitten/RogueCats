package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class RoguecraftCommand implements CommandExecutor {
    private final RoguecraftPlugin plugin;

    public RoguecraftCommand(RoguecraftPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);

        if (args.length == 0) {
            // Display player's stats or other information
            player.sendMessage("Your level: " + playerData.getLevel());
            player.sendMessage("Your experience: " + playerData.getExperience());
            return true;
        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("skill")) {
            // Handle skill-related commands
            if (args.length == 2 && args[1].equalsIgnoreCase("fireball")) {
                // Cast the fireball skill
                Skill fireball = plugin.getSkillManager().getSkill("Fireball");
                if (fireball != null) {
                    plugin.getCombatManager().castSkill(player, fireball);
                } else {
                    player.sendMessage("The Fireball skill is not registered.");
                }
                return true;
            }
            // Add more skill-related commands here
        }

        // Handle other commands here
        return false;
    }
}
