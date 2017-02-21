package com.family_budget.family;

import java.time.Month;
import java.util.Map;


/**
 * @author Dmytro Melnychuk
 */
public interface Person
{

    String getFirstName();

    String getInternalName();

    Integer getSallaryPerMonth();

    Integer getConstantSpendsPerMonth();

    Map getTotalOfSpentMoneyPerYear();

    Map getTotalOfSpentMoneyPerMonth( Month month );

}
