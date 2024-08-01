package com.example.roguecraftplugin;

public class Ability {
    private String name;
    private String description;
    private int maxLevel;

    public Ability(String name, String description, int maxLevel) {
        this.name = name;
        this.description = description;
        this.maxLevel = maxLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}

public class AbilityManager {
    private Map<String, Ability> abilityMap;

    public AbilityManager() {
        abilityMap = new HashMap<>();
        registerAbilities();
    }

    private void registerAbilities() {
        registerAbility(new Ability("Cleave", "Deals additional damage in a frontal cone", 5));
        registerAbility(new Ability("Whirlwind", "Spin and strike nearby enemies", 3));
        // Register more abilities here
    }

    public void registerAbility(Ability ability) {
        abilityMap.put(ability.getName(), ability);
    }

    public Ability getAbility(String abilityName) {
        return abilityMap.get(abilityName);
    }
}
