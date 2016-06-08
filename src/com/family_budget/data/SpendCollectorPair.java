package com.family_budget.data;

import com.family_budget.family.Person;

/**
 * Created by Dmytro Melnychuk on 08/06/16.
 */
public class SpendCollectorPair {
    String currentSpendType;
    double spendSum;

    public SpendCollectorPair(String currentSpendType, double spendSum) {
        this.currentSpendType = currentSpendType;
        this.spendSum = spendSum;
    }

    public boolean containSpendType(String currentSpendType) {
        return this.currentSpendType.equalsIgnoreCase(currentSpendType);
    }

    public String getCurrentSpendType() {
        return currentSpendType;
    }

    public double getSpendSum() {
        return spendSum;
    }
}
