package com.family_budget.spends;

import com.family_budget.data.CounterAverageSpenSum;
import com.family_budget.data.SpendCollectorPair;
import com.family_budget.data.Spends;
import com.family_budget.family.Person;

import java.util.List;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public class SpendController
{

    private static final SpendController SPEND_CONTROLLER =
                    new SpendController();
    private final Spends spendData = new Spends();


    private SpendController()
    {
    }


    public static SpendController getInstance()
    {
        return SPEND_CONTROLLER;
    }


    public void addNewSpend(
                    String currentSpendType,
                    double spendSum,
                    Person personThatSpendMoney )
                    throws InccorectSpendTypeException
    {
        System.out.println(
                        "Be careful because your current balance before spend equal: " +
                                        this.currentBalanceInAccount(
                                                        personThatSpendMoney ) );
        spendData.addNewSpend(
                        personThatSpendMoney,
                        new SpendCollectorPair( currentSpendType, spendSum ) );

    }


    public void addNewIncome( Person personAddMoney, double incomeSum )
    {
        spendData.addNewIncome( personAddMoney, incomeSum );
    }


    public void addStartedIncome( Person personAddMoney, double incomeSum )
    {
        spendData.addStartedIncome( personAddMoney, incomeSum );
    }


    public void verifyIfCurrentSpendTypeExist( String currentSpendType )
                    throws InccorectSpendTypeException
    {
        boolean isTypedSpendTypeExist = false;
        for( String typeSpend : SpendsNameContainer.AVAILABLE_SPENDS() )
        {
            if( currentSpendType.equalsIgnoreCase( typeSpend ) )
                isTypedSpendTypeExist = true;
        }

        if( !isTypedSpendTypeExist )
            throw new InccorectSpendTypeException( currentSpendType );

    }


    public boolean containsPerson( Person person )
    {
        return spendData.containsPerson( person );
    }


    public double currentBalanceInAccount( Person person )
    {
        return spendData.getCurrentBalance( person );
    }


    public void printAverageSpendSumsByType( Person currentPerson )
    {
        CounterAverageSpenSum counterAverageSpenSum =
                        spendData.getListForCountAveregeSum( currentPerson );
        Map<String, List<Double>> spendSumsBytype =
                        counterAverageSpenSum.getCurrentSpendType();
        System.out.println( currentPerson.getFirstName() +
                        "has follow average spends:" );
        for( Map.Entry<String, List<Double>> spendSumsByType : spendSumsBytype
                        .entrySet() )
        {
            String key = spendSumsByType.getKey();
            double calculateAverage =
                            this.calculateAverage( spendSumsByType.getValue() );
            System.out.println(
                            "Spend type " + key + " has average spend sum: " +
                                            calculateAverage );
        }
    }


    private double calculateAverage( List<Double> marks )
    {
        double sum = 0;
        if( !marks.isEmpty() )
        {
            for( Double mark : marks )
            {
                sum += mark;
            }
            return sum / marks.size();
        }
        return sum;
    }
}
