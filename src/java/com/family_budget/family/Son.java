package com.family_budget.family;

import java.time.Month;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public class Son
                extends PersonBase
{
    final String name;
    private int summaryCost = 0;


    public Son( String name )
    {
        this.name = name;
    }


    public void addNewSpendToSummarySpend( Number sum )
    {
        summaryCost += (Double)sum;
    }


    @Override
    public String getInternalName()
    {
        return "son";
    }


    @Override
    public String getFirstName()
    {
        return name;
    }


    @Override
    public Integer getSallaryPerMonth()
    {
        return null;
    }


    @Override
    public Integer getConstantSpendsPerMonth()
    {
        return null;
    }


    @Override
    public Map getTotalOfSpentMoneyPerYear()
    {
        return null;
    }


    @Override
    public Map getTotalOfSpentMoneyPerMonth( Month month )
    {
        return null;
    }
}
