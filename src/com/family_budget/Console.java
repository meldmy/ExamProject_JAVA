package com.family_budget;

import com.family_budget.family.Person;
import com.family_budget.family.fabric.PersonContainer;
import com.family_budget.family.fabric.ApsentPersonInMetaDataException;
import com.family_budget.spends.InccorectSpendTypeException;
import com.family_budget.spends.SpendReceiver;
import com.family_budget.spends.SpendsNameContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmytro Melnychuk on 19.03.16.
 */
public class Console {

    public static void main(String[] args) throws IOException {
        Person personWhoSpendMoney;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Program work till time that you enter word \"exit\" (without brackets)");
        System.out.println("You can choose who current spend money. Available persons: "
                + PersonContainer.getAllAvailablePersonsFromFamilyForOperations());

        choosePersonWhoSpendMoney(bufferedReader);

    }

    private static void choosePersonWhoSpendMoney(BufferedReader bufferedReader) throws IOException {
        Person currentPerson;
        double inputSum = 0;
        String currentSpendType;
        String typeOperation;
        SpendReceiver spendReceiver = SpendReceiver.getInstance();
        String namePersonWhoSpendMoney = "";
        while (namePersonWhoSpendMoney != "exit") {
            System.out.print("Write who making this operation: ");

            namePersonWhoSpendMoney = bufferedReader.readLine();
            try {
                currentPerson= PersonContainer.receivePerson(namePersonWhoSpendMoney);
                System.out.print("Write which type of finance operation you will doing now (spend, income): ");
                typeOperation = bufferedReader.readLine();
                if(typeOperation.equalsIgnoreCase("spend")) {
                    if (!spendReceiver.containsPerson(currentPerson)) {
                        System.out.print("Write how much money " + currentPerson.getName() + " has now in the account: ");
                        spendReceiver.addNewIncome(currentPerson, Double.parseDouble(bufferedReader.readLine()));
                    }
                    System.out.println("Write what type of spending will: ");
                    currentSpendType = bufferedReader.readLine();
                    System.out.print("Write how much will " + namePersonWhoSpendMoney + " spend: ");
                    inputSum = Double.parseDouble(bufferedReader.readLine());
                    spendReceiver.addNewSpend(currentSpendType, inputSum, currentPerson);
                }else if(typeOperation.equalsIgnoreCase("income")) {
                    spendReceiver.addNewIncome(currentPerson, Double.parseDouble(String.valueOf(bufferedReader.read())));
                }

            } catch (ApsentPersonInMetaDataException personIsApsentInMetaData) {
                System.out.println("You wrote incorrect name of person. Available persons: "
                        + PersonContainer.getAllAvailablePersonsFromFamilyForOperations());
            } catch (InccorectSpendTypeException e) {
                System.out.println("You wrote not exist spend type. Available spend types: ");
                for (String availableSpend : SpendsNameContainer.AVAILABLE_SPENDS()) {
                    System.out.println(availableSpend+" ");
                }
            }

        }
        System.out.println("See you soon...");
    }
}
