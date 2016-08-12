package com.family_budget.family;

import java.time.Month;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public abstract class PersonBase
                implements Person
{

    public abstract String getFirstName();

    public abstract String getInternalName();

    public abstract Integer getSallaryPerMonth();

    public abstract Integer getConstantSpendsPerMonth();

    public abstract Map getTotalOfSpentMoneyPerYear();

    public abstract Map getTotalOfSpentMoneyPerMonth( Month month );

}
