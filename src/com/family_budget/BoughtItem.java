package com.family_budget;

import com.family_budget.spends.SpendType;


/**
 * @author Dmytro Melnychuk
 */
public interface BoughtItem
{

    String getName();

    Integer getPrice();

    SpendType getTypeOfSpend();
}
