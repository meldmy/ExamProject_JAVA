package com.family_budget.spends.impl;

import com.family_budget.spends.Service;


/**
 * @author Dmytro Melnychuk
 */
public class Transport
                extends Service
{

    public static String SPEND_TYPE_NAME = "Transport";

    final String name;


    public Transport( String name, double price )
    {

        this.name = name;
        super.price = price;
    }
}
