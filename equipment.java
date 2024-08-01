package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class EquipmentManager {
    private RoguecraftPlugin plugin;
    private Map<String, Equipment> equipmentMap;

    public EquipmentManager(RoguecraftPlugin plugin) {
        this.plugin = plugin;
        this.equipmentMap = new HashMap<>();
    }

    public void registerEquipment(Equipment equipment) {
        equipmentMap.put(equipment.getName(), equipment);
    }

    public Equipment getEquipment(String name) {
        return equipmentMap.get(name);
    }

    public void equipItem(Player player, Equipment equipment) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.equipItem(equipment);
    }

    public void unequipItem(Player player, Equipment equipment) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.unequipItem(equipment);
    }
}

public class Equipment {
    private String name;
    private String description;
    private Map<Stat, Integer> statModifiers;

    public Equipment(String name, String description, Map<Stat, Integer> statModifiers) {
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
