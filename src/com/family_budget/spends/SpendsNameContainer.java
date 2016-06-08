package com.family_budget.spends;

import com.family_budget.spends.impl.*;

import java.util.*;

/**
 * Created by Dmytro Melnychuk on 05/06/16.
 */
public class SpendsNameContainer {

    public static Map<String, HashSet<String>> AVAILABLE_SPENDS_WITH_TYPE() {
        Map availableSpends = new HashMap<String, HashSet<String>>();
        availableSpends.put("Goods", Collections.unmodifiableSet(receiveAvailableGoods()));
        availableSpends.put("Service", Collections.unmodifiableSet(receiveAvailableServises()));
        return availableSpends;
    }

    public static Set<String> AVAILABLE_SPENDS() {
        Set availableSpends = new HashSet<>();
        availableSpends.addAll(Collections.unmodifiableSet(receiveAvailableGoods()));
        availableSpends.addAll(Collections.unmodifiableSet(receiveAvailableServises()));
        return availableSpends;
    }

    private static Set receiveAvailableGoods() {
        Set availableGoods = new HashSet<>();
        availableGoods.add(Food.SPEND_TYPE_NAME);
        availableGoods.add(Clothes.SPEND_TYPE_NAME);
        availableGoods.add(Relax.SPEND_TYPE_NAME);
        return availableGoods;
    }

    private static Set receiveAvailableServises() {
        Set availableGoods = new HashSet<>();
        availableGoods.add(Transport.SPEND_TYPE_NAME);
        availableGoods.add(Rent.SPEND_TYPE_NAME);
        return availableGoods;
    }


}
