package com.example.roguecraftplugin;

public class CharacterAttributes {
    private int strength;
    private int agility;
    private int intelligence;
    private int vitality;

    public CharacterAttributes(int strength, int agility, int intelligence, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public void increaseAgility(int amount) {
        agility += amount;
    }

    public void increaseIntelligence(int amount) {
        intelligence += amount;
    }

    public void increaseVitality(int amount) {
        vitality += amount;
    }
}
