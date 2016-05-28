package com.family_budget.income;

/**
 * Created by Dmytro Melnychuk on 23/04/16.
 */
public abstract class RegularRevenue implements IncomeType{

    protected double size;

    @Override
    public String getType() {
        return "Regular revenue";
    }

    protected double getSize() {
        return size;
    }
}
