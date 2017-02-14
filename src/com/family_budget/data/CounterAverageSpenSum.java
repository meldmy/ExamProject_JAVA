package com.family_budget.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public class CounterAverageSpenSum
{
    static final Map<String, List<Double>> counterSpendSumsByType =
                    new HashMap<>();


    public CounterAverageSpenSum( String currentSpendType, double spendSum )
    {
        if( counterSpendSumsByType.containsKey( currentSpendType ) )
        {
            List<Double> currentSumsByType =
                            counterSpendSumsByType.get( currentSpendType );
            currentSumsByType.add( spendSum );
            counterSpendSumsByType.put( currentSpendType, currentSumsByType );
        }
        else
        {
            List<Double> sumsByType = new ArrayList<>();
            sumsByType.add( spendSum );
            counterSpendSumsByType.put( currentSpendType, sumsByType );
        }

    }


    public Map<String, List<Double>> getCurrentSpendType()
    {
        return counterSpendSumsByType;
    }

}
