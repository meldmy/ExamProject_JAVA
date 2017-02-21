package com.family_budget.data;

import com.family_budget.family.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public class Spends
{

    private Map<Person, SpendTypePair> simpleDataStorage = new HashMap<>();
    private Map<Person, CounterAverageSpenSum> counterForCountAveregeSum =
                    new HashMap<>();
    private Map<Person, Double> currentBalance = new HashMap<>();


    public void addNewSpend(
                    Person person,
                    String spendType, double spendSum )
    {
        if( personContainsSpendType( person, spendType ) )
        {
            spendSum +=simpleDataStorage.get( person ).getSpendSum();
        }
        simpleDataStorage.put( person, new SpendTypePair(spendType, spendSum) );
        counterForCountAveregeSum.put(
                        person,
                        new CounterAverageSpenSum( spendType, spendSum ) );
        currentBalance.put( person, currentBalance.get( person ) - spendSum );
    }


    private boolean personContainsSpendType( Person person, String spendType )
    {
        return containsPerson( person ) && simpleDataStorage.get( person )
                        .containSpendType( spendType );
    }


    public boolean containsPerson( Person person )
    {
        return simpleDataStorage.containsKey( person );
    }


    public void addNewIncome( Person personAddMoney, double incomeSum )
    {
        if( currentBalance.containsKey( personAddMoney ) )
        {
            incomeSum += currentBalance.get( personAddMoney );
        }
        currentBalance.put( personAddMoney, incomeSum );
    }


    public Map<String, List<Double>> getSpendSumsBytype( Person person )
    {
        return counterForCountAveregeSum.containsKey( person )
                        ? counterForCountAveregeSum.get( person ).getCurrentSpendType()
                        : Collections.emptyMap();
    }


    public void addStartedIncome( Person personAddMoney, double incomeSum )
    {
        currentBalance.put( personAddMoney, incomeSum );
    }


    public Double getCurrentBalance( Person person )
    {
        return currentBalance.get( person );
    }
}
