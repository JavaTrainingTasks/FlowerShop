package ua.com.training.model.services;

import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FlowersFinder {
    public static ArrayList<Flower> findFlowersInRangeOfLengths(Bouquet bouquet, double lowerBound, double higherBound) {
        ArrayList<Flower> flowers = bouquet.getFlowers()
                      .stream()
                      .filter(flower -> flower.getLength() >= lowerBound && flower.getLength()<= higherBound)
                      .collect(Collectors.toCollection(ArrayList<Flower>::new));
        System.out.println(flowers);
        return flowers;
    }
}
