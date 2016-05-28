package com.family_budget.family;

import com.family_budget.Person;

import java.time.Month;
import java.util.Map;

/**
 * Created by Dmytro Melnychuk on 14/05/16.
 */
public class Mother implements Person{
    final String name;
    private int summaryCost=0;

    public Mother(String name){
        this.name=name;
    }

    public void addNewSpendToSummarySpend(Number sum)
    {
        summaryCost+=(Double) sum;
    }

    @Override
    public String getKeyForOperations()
    {
        return "mother";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getSallaryPerMonth() {
        return null;
    }

    @Override
    public Integer getConstantSpendsPerMonth() {
        return null;
    }

    @Override
    public Map getTotalOfSpentMoneyPerYear() {
        return null;
    }

    @Override
    public Map getTotalOfSpentMoneyPerMonth(Month month) {
        return null;
    }
}
