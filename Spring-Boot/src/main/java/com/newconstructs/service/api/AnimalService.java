package com.newconstructs.service.api;

import com.newconstructs.domain.Animal;
import com.newconstructs.utils.AnimalRate;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Validated
public interface AnimalService {
    public List<Animal> findAll();

    public Set<String> findAllCategory();

    public List<AnimalRate> findRatingByType(String type);

    public List<Animal> findAllByType(String type);

    public AnimalRate calcMaxStatistics(List<AnimalRate> animals);

    public AnimalRate calcMinStatistics(List<AnimalRate> animals);

    public double calcAvgStatistics(List<AnimalRate> animals);
}
