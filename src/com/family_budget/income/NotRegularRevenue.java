package com.family_budget.income;

/**
 * @author Dmytro Melnychuk
 */
public abstract class NotRegularRevenue
                implements IncomeType
{

    protected double size;


    @Override
    public String getType()
    {
        return "Not regular revenue";
    }


    protected double getSize()
    {
        return size;
    }
}
