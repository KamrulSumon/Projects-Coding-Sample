package com.newconstructs.utils;


import com.newconstructs.domain.Animal;

/**
 * This class is used to store animal and their corresponding rating.
 * Eevery animal has a rating associated with it.
 */

public class AnimalRate {
    private Animal animal;
    private double rating;

    public AnimalRate(double rating) {
        this.rating = rating;
    }

    public AnimalRate(Animal animal, double rating) {
        this.animal = animal;
        this.rating = rating;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
