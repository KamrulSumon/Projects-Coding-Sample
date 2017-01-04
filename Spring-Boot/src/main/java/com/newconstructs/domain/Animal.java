package com.newconstructs.domain;

public class Animal {
    public enum AnimalType {DOG, CAT, SNAKE, RABBIT}


    private AnimalType animalType;
    private String name;
    private int offense;
    private int defense;
    private int health;
    private int items;

    public Animal(AnimalType animalType, String name, int offense, int defense, int health, int items) {

        this.animalType = animalType;
        this.name = name;
        this.offense = offense;
        this.defense = defense;
        this.health = health;
        this.items = items;
    }

    public AnimalType getAnimalType() {

        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {

        this.animalType = animalType;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getOffense() {

        return offense;
    }

    public void setOffense(int offense) {

        this.offense = offense;
    }

    public int getDefense() {

        return defense;
    }

    public void setDefense(int defense) {

        this.defense = defense;
    }

    public int getHealth() {

        return health;
    }

    public void setHealth(int health) {

        this.health = health;
    }

    public int getItems() {

        return items;
    }

    public void setItems(int items) {

        this.items = items;
    }
}
