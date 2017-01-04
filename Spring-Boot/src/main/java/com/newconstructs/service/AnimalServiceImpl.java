package com.newconstructs.service;

import com.newconstructs.domain.Animal;
import com.newconstructs.domain.Animal.AnimalType;
import com.newconstructs.service.api.AnimalService;
import com.newconstructs.utils.AnimalRate;
import com.newconstructs.utils.AnimalUtil;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AnimalServiceImpl implements AnimalService {
    private static final List<Animal> ANIMALS;

    static {
        ANIMALS = new ArrayList<>();

        ANIMALS.add(new Animal(AnimalType.DOG, "Spot", 10, 7, 17, 0));
        ANIMALS.add(new Animal(AnimalType.DOG, "Rover", 15, 5, 2, 6));
        ANIMALS.add(new Animal(AnimalType.DOG, "Fido", 8, 6, 12, 15));
        ANIMALS.add(new Animal(AnimalType.CAT, "Mittens", 18, 3, 3, 0));
        ANIMALS.add(new Animal(AnimalType.CAT, "Snowball", 5, 0, 14, 1));
        ANIMALS.add(new Animal(AnimalType.CAT, "Waffles", 8, 11, 2, 18));
        ANIMALS.add(new Animal(AnimalType.SNAKE, "Slider", 6, 16, 14, 3));
        ANIMALS.add(new Animal(AnimalType.SNAKE, "Milton", 16, 6, 11, 17));
        ANIMALS.add(new Animal(AnimalType.SNAKE, "Spike", 6, 18, 2, 5));
        ANIMALS.add(new Animal(AnimalType.SNAKE, "Alice", 9, 11, 4, 6));
        ANIMALS.add(new Animal(AnimalType.RABBIT, "Flopsy", 14, 0, 12, 2));
        ANIMALS.add(new Animal(AnimalType.RABBIT, "Peter", 18, 18, 14, 3));
        ANIMALS.add(new Animal(AnimalType.RABBIT, "Oreo", 7, 4, 9, 1));
    }

    @Override
    public List<Animal> findAll() {

        return ANIMALS;
    }

    /**
     * This method is used to find unique animal type from a list of animal
     * @return Set<String>  This returns unique category of animals
     */
    @Override
    public Set<String> findAllCategory() {

        Set<String> animalType = new HashSet<>();

        for (Animal animal : ANIMALS) {
            animalType.add(animal.getAnimalType().toString());
        }

        animalType.add("All");

        return animalType;
    }

    /**
     * This method is used to calculate the rating of each animal of the selected type
     * @param type String, accept a animal type of string
     * @return List<AnimalRate>, This returns list of animals along with their rating
     */
    @Override
    public List<AnimalRate> findRatingByType(String type) {

        List<AnimalRate> animalRating = new ArrayList<>();
        List<Animal> animals = findAllByType(type);

        //calculate each animal rating of a particular type
        for (Animal animal : animals) {
            double offense = AnimalUtil.calcOffense(animal);
            double defense = AnimalUtil.calcDefense(animal);
            double health = AnimalUtil.calcHealth(animal);
            animalRating.add(new AnimalRate(animal, (offense + defense + health)));
        }

        //sort descending
        Collections.sort(animalRating, new Comparator<AnimalRate>() {
            @Override
            public int compare(AnimalRate a1, AnimalRate a2) {
                return a1.getRating() < a2.getRating() ? 1 : -1;
            }
        });



        return animalRating;
    }

    /**
     * This method is used to find list of animals from a given animal type
     * @param type, String, accept a animal type of string
     * @return List<Animal>, This returns list of animals of a given type
     */
    public List<Animal> findAllByType(String type) {
        List<Animal> animals = new ArrayList<>();

        if (type.equals("All")) return ANIMALS;

        for (Animal animal : ANIMALS) {
            if (animal.getAnimalType().toString().equals(type)) {
                animals.add(animal);
            }
        }
        return animals;
    }

    /**
     * This method is used to calculate the max statistics from a given list of animals with rating
     * @param animals List<AnimalRate>, accepts list of animals with their corresponding rating. It assume that animal already sorted by desc
     * @return AnimalRate, This returns max rating animal with rating
     */
    public AnimalRate calcMaxStatistics(List<AnimalRate> animals) {

        if (animals == null) return null;
        return animals.get(0);
    }

    /**
     * This method is used to calculate the min statistics from a given list of animals with rating
     * @param animals List<AnimalRate>, accepts list of animals with their corresponding rating. It assume that animal already sorted by desc
     * @return AnimalRate, This returns min rating animal with rating
     */
    public AnimalRate calcMinStatistics(List<AnimalRate> animals) {

        if (animals == null) return null;
        return animals.get(animals.size() - 1);
    }

    /**
     * This method is used to calculate the average statistics from a given list of animals with rating
     * @param animals List<AnimalRate>, accepts list of animals with their corresponding rating. It assume that animal already sorted by desc
     * @return double, This returns average rating animal
     */
    public double calcAvgStatistics(List<AnimalRate> animals) {

        if (animals == null) return 0.0;
        int len = animals.size();
        double total = 0.0;

        for (AnimalRate animal : animals) {
            total += animal.getRating();
        }

        return (total / len);
    }

}
