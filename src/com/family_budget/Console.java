package com.family_budget;

import com.family_budget.family.fabric.PersonContainer;
import com.family_budget.family.fabric.PersonIsApsentInMetaData;

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
        Person personWhoSpendMoney;
        String namePersonWhoSpendMoney = "";
        while (namePersonWhoSpendMoney != "exit") {
            System.out.print("Write who will spend money: ");

            namePersonWhoSpendMoney = bufferedReader.readLine();
            try {
                personWhoSpendMoney= PersonContainer.receivePerson(namePersonWhoSpendMoney);
            } catch (PersonIsApsentInMetaData personIsApsentInMetaData) {
                System.out.println("You wrote incorrect name of person. Available persons: "
                        + PersonContainer.getAllAvailablePersonsFromFamilyForOperations());
            }

        }
    }
}
