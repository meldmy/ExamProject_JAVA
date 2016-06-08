package com.family_budget.spends.impl;

import com.family_budget.spends.Goods;
import com.sun.jdi.connect.Connector;

/**
 * Created by Dmytro Melnychuk on 09.04.16.
 */
public class Clothes extends Goods{

    public static String SPEND_TYPE_NAME = "Clothes";

    final String name;

    public Clothes(String name, double price) {

        this.name=name;
        super.price=price;
    }


}
