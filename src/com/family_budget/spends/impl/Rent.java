package com.family_budget.spends.impl;

import com.family_budget.spends.Service;

/**
 * Created by Dmytro Melnychuk on 09.04.16.
 */
public class Rent extends Service{

    public static String SPEND_TYPE_NAME = "Rent";


    final String name;

    public Rent(String name, double price) {

        this.name=name;
        super.price=price;
    }
}
