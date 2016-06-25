package com.family_budget.data;

import java.util.*;

/**
 * Created by Dmytro Melnychuk on 11/06/16.
 */
public class CounterAverageSpenSum {
    static final Map<String, List<Double>> counterSpendSumsByType = new HashMap<>();

    public CounterAverageSpenSum(String currentSpendType, double spendSum) {
        if(counterSpendSumsByType.containsKey(currentSpendType)){
            List<Double> currentSumsByType = counterSpendSumsByType.get(currentSpendType);
            currentSumsByType.add(spendSum);
        counterSpendSumsByType.put(currentSpendType, currentSumsByType);
        }else {
            List<Double> sumsByType = new ArrayList<>();
            sumsByType.add(spendSum);
            counterSpendSumsByType.put(currentSpendType, sumsByType);
        }

    }

    public Map<String, List<Double>> getCurrentSpendType() {
        return counterSpendSumsByType;
    }

}
