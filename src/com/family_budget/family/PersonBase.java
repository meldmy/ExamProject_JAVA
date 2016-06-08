package com.family_budget.family;

import java.time.Month;
import java.util.Map;

/**
 * Created by Dmytro Melnychuk on 05/06/16.
 */
public abstract class PersonBase implements Person {

    public abstract String getName();

    public abstract String getKeyForOperations();

    public abstract Integer getSallaryPerMonth();

    public abstract Integer getConstantSpendsPerMonth();

    public abstract Map getTotalOfSpentMoneyPerYear();

    public abstract Map getTotalOfSpentMoneyPerMonth(Month month);


}
