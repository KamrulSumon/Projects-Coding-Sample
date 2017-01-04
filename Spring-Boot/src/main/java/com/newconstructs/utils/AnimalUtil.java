package com.newconstructs.utils;

import com.newconstructs.domain.Animal;

/**
 * This class usually contains some utilities methods to performed some functions related to animals
 */
public class AnimalUtil {

    /**
     * This method is used to calculate the offense as per the specification
     * @param animal Animal, accepts an animal object
     * @return double, This returns a double value that is a offense of an animal
     */
    public static double calcOffense(Animal animal) {
        if (animal == null) return 0;
        double defense = 0.0;
        double health = 0.0;
        double items = 0.0;

        defense += animal.getDefense();
        health += animal.getHealth();
        items += animal.getItems();

        return 2 * defense + 2 * health + items;
    }

    /**
     * This method is used to calculate the defense as per the specification
     * @param animal Animal, accepts an animal object
     * @return double, This returns a double value that is a defense of an animal
     */
    public static double calcDefense(Animal animal) {
        if (animal == null) return 0;
        double defense = 0.0;
        defense = animal.getDefense();

        return defense;
    }

    /**
     * This method is used to calculate the health as per the specification
     * @param animal Animal, accepts an animal object
     * @return double, This returns a double value that is a health of an animal
     */
    public static double calcHealth(Animal animal) {
        if (animal == null) return 0;
        double health = 0;

        int curDef = animal.getDefense();
        int curHel = animal.getHealth();
        if (curDef < 10)
            health = Math.ceil(curHel / 2);
        else
            health = curHel;    //Assumption

        return health;
    }

}
