package com.family_budget.spends;

import com.family_budget.data.SpendCollectorPair;
import com.family_budget.data.SpendsData;
import com.family_budget.family.Person;

/**
 * Created by Dmytro Melnychuk on 05/06/16.
 */
public class SpendReceiver {

    private static final SpendReceiver spendReceiver = new SpendReceiver();
    private final SpendsData spendData = new SpendsData();
    ;

    private SpendReceiver() {
    }

    public void addNewSpend(String currentSpendType, double spendSum, Person personThatSpendMoney) throws InccorectSpendTypeException {
        verifyIfCurrentSpendTypeExist(currentSpendType);
        System.out.println("Be careful because your current balance before spend equal: " + this.currentBalanceInAccount(personThatSpendMoney));
        spendData.addNewSpend(personThatSpendMoney, new SpendCollectorPair(currentSpendType, spendSum));

    }

    public void addNewIncome(Person personAddMoney, double incomeSum) {
        spendData.addNewIncome(personAddMoney, incomeSum);
    }

    private void verifyIfCurrentSpendTypeExist(String currentSpendType) throws InccorectSpendTypeException {
        boolean isTypedSpendTypeExist = false;
        for (String typeSpend : SpendsNameContainer.AVAILABLE_SPENDS()) {

            if (currentSpendType.equalsIgnoreCase(typeSpend))
                isTypedSpendTypeExist = true;
        }

        if (isTypedSpendTypeExist == false)
            throw new InccorectSpendTypeException(currentSpendType);

    }

    public boolean containsPerson(Person person) {
        return spendData.getSimpleDataStorage().containsKey(person);
    }

    public double currentBalanceInAccount(Person person) {
        return spendData.getCurrentBalance(person);
    }

    public static SpendReceiver getInstance() {
        return spendReceiver;
    }
}
