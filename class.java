package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class CharacterClassManager {
    private RoguecraftPlugin plugin;
    private Map<String, CharacterClass> characterClasses;

    public CharacterClassManager(RoguecraftPlugin plugin) {
        this.plugin = plugin;
        this.characterClasses = new HashMap<>();
    }

    public void registerCharacterClass(CharacterClass characterClass) {
        characterClasses.put(characterClass.getName(), characterClass);
    }

    public CharacterClass getCharacterClass(String name) {
        return characterClasses.get(name);
    }

    public void assignCharacterClass(Player player, CharacterClass characterClass) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.setCharacterClass(characterClass);
    }
}

public class CharacterClass {
    private String name;
    private String description;
    private Map<Stat, Integer> statModifiers;

    public CharacterClass(String name, String description, Map<Stat, Integer> statModifiers) {
        this.name = name;
        this.description = description;
        this.statModifiers = statModifiers;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<Stat, Integer> getStatModifiers() {
        return statModifiers;
    }
}
