package ua.com.training.model.services;

import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This class is a service class for Flowers
 */
public class FlowersFinder {
    /**
     * Search flowers in bouquet in perset range
     * @param bouquet
     * @param lowerBound
     * @param higherBound
     * @return sorted flowers of bouquet
     */
    public static ArrayList<Flower> findFlowersInRangeOfLengths(Bouquet bouquet, double lowerBound, double higherBound) {
        ArrayList<Flower> flowers = bouquet.getFlowers()
                      .stream()
                      .filter(flower -> flower.getLength() >= lowerBound && flower.getLength()<= higherBound)
                      .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(flowers);
        return flowers;
    }
}
