package com.family_budget;

import com.family_budget.spends.SpendType;

/**
 * Created by Dmytro Melnychuk on 07.04.16.
 */
public interface BoughtItem {

    String getName();

    Integer getPrice();



    SpendType getTypeOfSpend();
}
