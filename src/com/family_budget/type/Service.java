package com.family_budget.type;

/**
 * Created by Dmytro Melnychuk on 08.04.16.
 */
public class Service implements SpendType{
    @Override
    public String getType() {
        return "Service";
    }
}