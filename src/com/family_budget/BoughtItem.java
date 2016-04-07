package com.family_budget;

/**
 * Created by Dmytro Melnychuk on 07.04.16.
 */
public interface BoughtItem {

    String getName();

    Integer getPrice();

    SpendType getTypeOfSpend();
}
