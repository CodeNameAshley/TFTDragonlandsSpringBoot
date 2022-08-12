package com.TFTDragonlands.TFTDragonlands.TFTDragons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Dragons {
    @Id
    @SequenceGenerator(
            name = "tftdragonlands_sequence",
            sequenceName = "tftdragonlands_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tftdragonlands_sequence"
    )

    private Long id;
    private String name;
    private String trait;
    private int cost;
    private int health;
    private int mana;

    public Dragons() {
    }

    public Dragons(Long id,
                   String name,
                   String trait,
                   int cost,
                   int health,
                   int mana ) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.mana = mana;
        this.trait = trait;
    }

    public Dragons(String name,
                   String trait,
                   int cost,
                   int health,
                   int mana) {
        this.name = name;
        this.trait = trait;
        this.cost = cost;
        this.health = health;
        this.mana = mana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", trait='" + trait + '\'' +
                ", cost=" + cost +
                ", health=" + health +
                ", mana=" + mana +
                '}';
    }
}
