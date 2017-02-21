package com.family_budget.data;

/**
 * @author Dmytro Melnychuk
 */
public class SpendTypePair
{
    private final String spendType;
    private final double spendSum;


    public SpendTypePair( String spendType, double spendSum )
    {
        this.spendType = spendType;
        this.spendSum = spendSum;
    }


    boolean containSpendType( String spendType )
    {
        return this.spendType.equalsIgnoreCase( spendType );
    }

    double getSpendSum()
    {
        return spendSum;
    }
}
