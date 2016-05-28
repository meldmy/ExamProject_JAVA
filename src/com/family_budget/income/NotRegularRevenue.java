package com.family_budget.income;

/**
 * Created by Dmytro Melnychuk on 23/04/16.
 */
public abstract class NotRegularRevenue implements IncomeType{

    protected double size;

    @Override
    public String getType() {
        return "Not regular revenue";
    }

    protected double getSize() {
        return size;
    }
}
