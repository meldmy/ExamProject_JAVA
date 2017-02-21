package com.family_budget.spends.impl;

import com.family_budget.spends.Goods;


/**
 * @author Dmytro Melnychuk
 */
public class Food
                extends Goods
{

    public static String SPEND_TYPE_NAME = "Food";

    final String name;


    public Food( String name, double price )
    {

        this.name = name;
        super.price = price;
    }
}
