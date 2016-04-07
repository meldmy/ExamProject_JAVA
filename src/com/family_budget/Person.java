package com.family_budget;

import java.time.Month;
import java.util.Map;

/**
 * Created by Dmytro Melnychuk on 07.04.16.
 */
public interface Person {
    String getName();

    Integer getSallaryPerMonth();

    Integer getConstandSpendsPerMonth();

    Map getTotalOfSpentMoneyPerYear();

    Map getTotalOfSpentMoneyPerMonth(Month month);


}
