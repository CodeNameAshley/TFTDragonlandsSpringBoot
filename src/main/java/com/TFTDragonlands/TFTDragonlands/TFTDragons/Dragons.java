package com.TFTDragonlands.TFTDragonlands.TFTDragons;

public class Dragons {
    private String name;
    private String trait;
    private int cost;
    private int health;
    private int mana;

    public Dragons() {
    }

    public Dragons(String name, String trait, int cost, int health, int mana ) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.mana = mana;
        this.trait = trait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    @Override
    public String toString() {
        return "Dragons{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", health=" + health +
                ", mana=" + mana +
                ", trait='" + trait + '\'' +
                '}';
    }
}
