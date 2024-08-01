package com.example.roguecraftplugin;

public class ProgressionManager {
    private RoguecraftPlugin plugin;
    private SkillManager skillManager;

    public ProgressionManager(RoguecraftPlugin plugin, SkillManager skillManager) {
        this.plugin = plugin;
        this.skillManager = skillManager;
    }

    public void gainExperience(Player player, int experienceGain) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.grantExperience(experienceGain);
        checkLevelUp(player, playerData);
    }

    private void checkLevelUp(Player player, RoguecraftPlayerData playerData) {
        int currentLevel = playerData.getLevel();
        int requiredExperience = getRequiredExperience(currentLevel);

        if (playerData.getTotalExperience() >= requiredExperience) {
            playerData.setLevel(currentLevel + 1);
            player.sendMessage("Congratulations, you've leveled up to level " + (currentLevel + 1) + "!");
            handleLevelUp(player, playerData);
        }
    }

    private int getRequiredExperience(int level) {
        // Implement the logic to calculate the required experience for the next level
        return 100 * level;
    }

    private void handleLevelUp(Player player, RoguecraftPlayerData playerData) {
        // Grant the player a skill point to spend on new skills or skill upgrades
        playerData.grantSkillPoint();

        // Potentially grant the player other bonuses, such as attribute points or gear upgrades
    }
}
