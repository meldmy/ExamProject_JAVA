package com.family_budget.spends.impl;

import com.family_budget.spends.Goods;


/**
 * @author Dmytro Melnychuk
 */
public class Clothes
                extends Goods
{

    public static String SPEND_TYPE_NAME = "Clothes";

    final String name;


    public Clothes( String name, double price )
    {

        this.name = name;
        super.price = price;
    }

}
