package com.newconstructs.controller.home;

import com.newconstructs.domain.Animal;
import com.newconstructs.domain.api.Layout;
import com.newconstructs.service.api.AnimalService;
import com.newconstructs.utils.AnimalRate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Controller
public class HomeController {
    @Inject
    private AnimalService animalService;


    @Layout(
            title = "",
            description = "",
            selectedNav = "all"
    )
    @RequestMapping(value = {"/", "/home"})
    public String init(ModelMap modelMap) {

        List<Animal> animals = animalService.findAll();
        modelMap.put("animals", animals);

        return "home";
    }


    @Layout(
            title = "",
            description = "",
            selectedNav = "Rating"
    )
    @RequestMapping(value = {"/rate"}, method = RequestMethod.GET)
    public String showAnimalType(ModelMap modelMap) {

        Set<String> animalTypes = animalService.findAllCategory();
        modelMap.put("animals", animalTypes);

        return "rate";
    }


    @Layout(
            title = "",
            description = "",
            selectedNav = "Rating"
    )
    @RequestMapping(method = RequestMethod.POST, value = {"/rate"})
    public String showDetailsByType(@ModelAttribute("animalType") String animalType, ModelMap modelMap) {

        List<Animal> animals = animalService.findAllByType(animalType);
        List<AnimalRate> animalRatings = animalService.findRatingByType(animalType);
        AnimalRate maxStatistics = animalService.calcMaxStatistics(animalRatings);
        AnimalRate minStatistics = animalService.calcMinStatistics(animalRatings);
        double avg = animalService.calcAvgStatistics(animalRatings);

        modelMap.put("animals", animals);
        modelMap.put("animaltype", animalType);
        modelMap.put("rating", animalRatings);
        modelMap.put("max", maxStatistics);
        modelMap.put("min", minStatistics);
        modelMap.put("avg", avg);

        return "show-details";
    }
}