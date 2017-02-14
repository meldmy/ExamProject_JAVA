package com.family_budget.data;

/**
 * @author Dmytro Melnychuk
 */
public class SpendCollectorPair
{
    String currentSpendType;
    double spendSum;


    public SpendCollectorPair( String currentSpendType, double spendSum )
    {
        this.currentSpendType = currentSpendType;
        this.spendSum = spendSum;
    }


    public boolean containSpendType( String currentSpendType )
    {
        return this.currentSpendType.equalsIgnoreCase( currentSpendType );
    }


    public String getCurrentSpendType()
    {
        return currentSpendType;
    }


    public double getSpendSum()
    {
        return spendSum;
    }
}
