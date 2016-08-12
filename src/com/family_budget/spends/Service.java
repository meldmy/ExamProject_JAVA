package com.family_budget.spends;

/**
 * @author Dmytro Melnychuk
 */
public abstract class Service
                implements SpendType
{

    protected double price;


    @Override
    public String getType()
    {
        return "Service";
    }


    protected double getPrice()
    {
        return price;
    }


    private void setPrice( double priceForUpdating )
    {
        price = priceForUpdating;
    }
}
