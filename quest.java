package com.example.roguecraftplugin;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {
    private Map<String, Quest> quests;

    public QuestManager() {
        this.quests = new HashMap<>();
    }

    public void registerQuest(Quest quest) {
        quests.put(quest.getName(), quest);
    }

    public Quest getQuest(String name) {
        return quests.get(name);
    }

    public void assignQuest(Player player, Quest quest) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.assignQuest(quest);
    }

    public void completeQuest(Player player, Quest quest) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.completeQuest(quest);
        quest.reward(player);
    }
}

public class Quest {
    private String name;
    private String description;
    private QuestObjective[] objectives;
    private Reward reward;

    public Quest(String name, String description, QuestObjective[] objectives, Reward reward) {
        this.name = name;
        this.description = description;
        this.objectives = objectives;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public QuestObjective[] getObjectives() {
        return objectives;
    }

    public void reward(Player player) {
        reward.grant(player);
    }
}

public interface QuestObjective {
    boolean isCompleted(Player player);
}

public class Reward {
    private int experiencePoints;
    private Map<Item, Integer> items;

    public Reward(int experiencePoints, Map<Item, Integer> items) {
        this.experiencePoints = experiencePoints;
        this.items = items;
    }

    public void grant(Player player) {
        RoguecraftPlayerData playerData = plugin.getPlayerData(player);
        playerData.grantExperience(experiencePoints);
        items.forEach((item, count) -> {
            for (int i = 0; i < count; i++) {
                playerData.getInventory().addItem(item);
            }
        });
    }
}
