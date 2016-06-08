package com.family_budget.spends.impl;

import com.family_budget.spends.Service;

/**
 * Created by Dmytro Melnychuk on 09.04.16.
 */
public class Transport extends Service {

    public static String SPEND_TYPE_NAME = "Transport";

    final String name;

    public Transport(String name, double price) {

        this.name = name;
        super.price = price;
    }
}
