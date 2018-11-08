package ua.com.training.model.services;

import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FlowersFinder {
    public static ArrayList<Flower> findFlowersInRangeOfFreshness(Bouquet bouquet, double lowerBound, double higherBound) {
        return bouquet.getFlowers()
                      .stream()
                      .filter(flower -> flower.getFreshness() >= lowerBound && flower.getFreshness()<= higherBound)
                      .collect(Collectors.toCollection(ArrayList<Flower>::new));
    }
}
