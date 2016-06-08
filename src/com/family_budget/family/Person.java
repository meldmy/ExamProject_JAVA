package com.family_budget.family;

import java.time.Month;
import java.util.Map;

/**
 * Created by Dmytro Melnychuk on 07.04.16.
 */
public interface Person {


    String getName();

    String getKeyForOperations();

    Integer getSallaryPerMonth();

    Integer getConstantSpendsPerMonth();

    Map getTotalOfSpentMoneyPerYear();

    Map getTotalOfSpentMoneyPerMonth(Month month);


}
