package ua.com.training.model.services;

import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;

import java.util.ArrayList;
import java.util.Comparator;

public class SortService {
   public static Bouquet sortByFreshness( Bouquet bouquet) {
        bouquet.getFlowers().sort(Comparator.comparing(Flower::getFreshness));
        return bouquet;

    }
}
