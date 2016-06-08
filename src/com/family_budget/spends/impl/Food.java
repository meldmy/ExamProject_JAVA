package com.family_budget.spends.impl;

import com.family_budget.spends.Goods;

/**
 * Created by Dmytro Melnychuk on 09.04.16.
 */
public class Food extends Goods {

    public static String SPEND_TYPE_NAME = "Food";

    final String name;

    public Food(String name, double price) {

        this.name = name;
        super.price = price;
    }
}
