package com.family_budget.spends.impl;

import com.family_budget.spends.Goods;


/**
 * @author Dmytro Melnychuk
 */
public class Relax
                extends Goods
{

    public static String SPEND_TYPE_NAME = "Relax";

    final String name;


    public Relax( String name, double price )
    {

        this.name = name;
        super.price = price;
    }
}
