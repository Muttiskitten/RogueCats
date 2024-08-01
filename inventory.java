package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Player, Inventory> inventories;

    public InventoryManager() {
        this.inventories = new HashMap<>();
    }

    public Inventory getInventory(Player player) {
        return inventories.computeIfAbsent(player, k -> new Inventory());
    }

    public void addItem(Player player, Item item) {
        getInventory(player).addItem(item);
    }

    public void removeItem(Player player, Item item) {
        getInventory(player).removeItem(item);
    }
}

public class Inventory {
    private Map<Item, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        items.merge(item, 1, Integer::sum);
    }

    public void removeItem(Item item) {
        items.computeIfPresent(item, (k, v) -> v > 1 ? v - 1 : null);
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
