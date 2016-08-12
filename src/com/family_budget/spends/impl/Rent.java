package com.family_budget.spends.impl;

import com.family_budget.spends.Service;


/**
 * @author Dmytro Melnychuk
 */
public class Rent
                extends Service
{

    public static String SPEND_TYPE_NAME = "Rent";

    final String name;


    public Rent( String name, double price )
    {

        this.name = name;
        super.price = price;
    }
}
