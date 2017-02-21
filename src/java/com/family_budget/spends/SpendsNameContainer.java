package com.family_budget.spends;

import com.family_budget.spends.impl.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Dmytro Melnychuk
 */
public class SpendsNameContainer
{
    public static Set<String> AVAILABLE_SPENDS()
    {
        Set availableSpends = new HashSet<>();
        availableSpends.addAll( Collections.unmodifiableSet(
                        receiveAvailableGoods() ) );
        availableSpends.addAll( Collections.unmodifiableSet(
                        receiveAvailableServises() ) );
        return availableSpends;
    }


    private static Set receiveAvailableGoods()
    {
        Set availableGoods = new HashSet<>();
        availableGoods.add( Food.SPEND_TYPE_NAME );
        availableGoods.add( Clothes.SPEND_TYPE_NAME );
        availableGoods.add( Relax.SPEND_TYPE_NAME );
        return availableGoods;
    }


    private static Set receiveAvailableServises()
    {
        Set availableGoods = new HashSet<>();
        availableGoods.add( Transport.SPEND_TYPE_NAME );
        availableGoods.add( Rent.SPEND_TYPE_NAME );
        return availableGoods;
    }
}