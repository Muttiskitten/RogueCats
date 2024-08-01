package com.example.roguecraftplugin;

public class CombatManager {
    private RoguecraftPlugin plugin;

    public CombatManager(RoguecraftPlugin plugin) {
        this.plugin = plugin;
    }

    public void handlePlayerAttack(Player player, LivingEntity target) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);

        // Calculate the player's attack damage based on their equipped gear and abilities
        int attackDamage = calculateAttackDamage(playerData);

        // Apply the attack damage to the target
        target.damage(attackDamage);

        // Check if the target is defeated
        if (target.getHealth() <= 0) {
            handleEnemyDefeat(player, target);
        }
    }

    private int calculateAttackDamage(RoguecraftPlayerData playerData) {
        int baseDamage = 10; // Base damage
        int weaponDamage = playerData.getEquippedItem(ItemType.WEAPON).getStats().get(Stat.STRENGTH);
        int abilityDamage = 0;

        // Check if the player has any active abilities that modify their attack damage
        for (Map.Entry<Ability, Integer> entry : playerData.getAbilityLevels().entrySet()) {
            Ability ability = entry.getKey();
            int abilityLevel = entry.getValue();
            abilityDamage += ability.getDamageModifier(abilityLevel);
        }

        return baseDamage + weaponDamage + abilityDamage;
    }

    private void handleEnemyDefeat(Player player, LivingEntity enemy) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);

        // Grant experience and loot to the player
        grantExperience(playerData, enemy.getType());
        grantLoot(player, enemy);
    }

    private void grantExperience(RoguecraftPlayerData playerData, EntityType enemyType) {
        int experienceGrant = 50; // Base experience grant
        // Modify the experience grant based on the enemy type and the player's level
        playerData.grantExperience(experienceGrant);
    }

    private void grantLoot(Player player, LivingEntity enemy) {
        // Generate loot based on the enemy type and the player's level
        Item lootItem = generateLoot(enemy.getType(), player.getLevel());
        player.getInventory().addItem(lootItem.toItemStack());
    }

    private Item generateLoot(EntityType enemyType, int playerLevel) {
        // Implement loot generation logic based on the enemy type and the player's level
        return new Item("Crude Sword", ItemType.WEAPON, playerLevel, Map.of(Stat.STRENGTH, 5));
    }
}
