package com.family_budget.data;

import com.family_budget.family.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Melnychuk on 05/06/16.
 */
public class SpendsData {

    Map<Person, SpendCollectorPair> simpleDataStorage = new HashMap<>();
    Map<Person, CounterAverageSpenSum> counterForCountAveregeSum = new HashMap<>();
    Map<Person, Double> currentBalance = new HashMap<>();

    public void addNewSpend(Person person, SpendCollectorPair currentSpendPair) {
        if (simpleDataStorage.containsKey(person)) {
            if (simpleDataStorage.get(person).containSpendType(currentSpendPair.getCurrentSpendType())) {
                simpleDataStorage.put(person, receiveNewSpendCollectorPair(person, currentSpendPair));
                counterForCountAveregeSum.put(person, new CounterAverageSpenSum(currentSpendPair.getCurrentSpendType(), currentSpendPair.getSpendSum()));
            } else {
                simpleDataStorage.put(person, currentSpendPair);
                counterForCountAveregeSum.put(person, new CounterAverageSpenSum(currentSpendPair.getCurrentSpendType(), currentSpendPair.getSpendSum()));
            }
        } else {
            simpleDataStorage.put(person, currentSpendPair);
            counterForCountAveregeSum.put(person, new CounterAverageSpenSum(currentSpendPair.getCurrentSpendType(), currentSpendPair.getSpendSum()));
        }
        currentBalance.put(person, currentBalance.get(person) - currentSpendPair.getSpendSum());
    }

    public Map<Person, SpendCollectorPair> getSimpleDataStorage() {
        return simpleDataStorage;
    }

    private SpendCollectorPair receiveNewSpendCollectorPair(Person person, SpendCollectorPair currentSpendPair) {
        return new SpendCollectorPair(currentSpendPair.getCurrentSpendType(), simpleDataStorage.get(person).getSpendSum() + currentSpendPair.getSpendSum());
    }

    public void addNewIncome(Person personAddMoney, double incomeSum) {
        if (currentBalance.containsKey(personAddMoney)) {
            currentBalance.put(personAddMoney, currentBalance.get(personAddMoney) + incomeSum);
        } else {
            currentBalance.put(personAddMoney, incomeSum);
        }
    }

    public CounterAverageSpenSum getListForCountAveregeSum(Person person) {
        if(counterForCountAveregeSum.containsKey(person)){
            return counterForCountAveregeSum.get(person);
        }
        return null;
    }

    public void addStartedIncome(Person personAddMoney, double incomeSum) {
            currentBalance.put(personAddMoney, incomeSum);
    }


    public Double getCurrentBalance(Person person) {
        return currentBalance.get(person);
    }
}
