package com.family_budget.spends.impl;

import com.family_budget.spends.Service;

/**
 * Created by Dmytro Melnychuk on 09.04.16.
 */
public class Rents extends Service{

    final String name;

    public Rents(String name, double price) {

        this.name=name;
        super.price=price;
    }
}
