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
    private static final Map<String, List<Double>> SPENDS_BY_TYPE = new HashMap<>();


    CounterAverageSpenSum( String currentSpendType, double spendSum )
    {
        List<Double> currentSumsByType = receiveSumsByType( currentSpendType );
        currentSumsByType.add( spendSum );
        SPENDS_BY_TYPE.put( currentSpendType, currentSumsByType );
    }


    private List<Double> receiveSumsByType( String currentSpendType )
    {
        return SPENDS_BY_TYPE.containsKey( currentSpendType )
                        ? SPENDS_BY_TYPE.get( currentSpendType )
                        : new ArrayList<>();
    }


    public Map<String, List<Double>> getCurrentSpendType()
    {
        return SPENDS_BY_TYPE;
    }

}
