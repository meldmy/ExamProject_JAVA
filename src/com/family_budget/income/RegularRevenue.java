package com.family_budget.income;

/**
 * @author Dmytro Melnychuk
 */
public abstract class RegularRevenue
                implements IncomeType
{

    protected double size;


    @Override
    public String getType()
    {
        return "Regular revenue";
    }


    protected double getSize()
    {
        return size;
    }
}
