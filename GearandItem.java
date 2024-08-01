package com.example.roguecraftplugin;

public class Item {
    private String name;
    private ItemType type;
    private int level;
    private Map<Stat, Integer> stats;

    public Item(String name, ItemType type, int level, Map<Stat, Integer> stats) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Map<Stat, Integer> getStats() {
        return stats;
    }
}

public enum ItemType {
    WEAPON,
    ARMOR,
    ACCESSORY
}

public enum Stat {
    STRENGTH,
    DEXTERITY,
    INTELLIGENCE,
    VITALITY,
    DEFENSE
}
