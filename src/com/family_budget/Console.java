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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Program work till time that you enter word \"exit\" (without brackets)");
        System.out.println("You can choose who current spend money. Available persons: "
                + PersonContainer.getAllAvailablePersonsFromFamilyForOperations());

        choosePersonWhoSpendMoney(bufferedReader);

    }

    private static void choosePersonWhoSpendMoney(BufferedReader bufferedReader) throws IOException {
        Person currentPerson;
        String typeOperation;
        SpendReceiver spendReceiver = SpendReceiver.getInstance();
        String namePersonWhoSpendMoney = "";
        while (namePersonWhoSpendMoney != "exit") {
            System.out.print("Write who making this operation: ");
            namePersonWhoSpendMoney = bufferedReader.readLine();

            try {
                currentPerson = PersonContainer.receivePerson(namePersonWhoSpendMoney);

                System.out.println("Choose operation type:\n1)New spend\n2)New income\n3)Get average spend sum\n4)Get current balance");
                typeOperation = bufferedReader.readLine();
                if (typeOperation.equalsIgnoreCase("spend") || typeOperation.contains("1")) {
                    doSpendLogicNEED_RENAME(bufferedReader, currentPerson, spendReceiver, namePersonWhoSpendMoney);
                } else if (typeOperation.equalsIgnoreCase("income") || typeOperation.contains("2")) {
                    System.out.print("Write how much will " + namePersonWhoSpendMoney + " adding to account: ");
                    spendReceiver.addNewIncome(currentPerson, Double.parseDouble(bufferedReader.readLine()));
                }else if((typeOperation.equalsIgnoreCase("average") || typeOperation.contains("3")) ){
                    spendReceiver.printAverageSpendSumsByType(currentPerson);
                }else if((typeOperation.equalsIgnoreCase("current") || typeOperation.equalsIgnoreCase("balance") || typeOperation.contains("4")) ){
                    System.out.println(spendReceiver.currentBalanceInAccount(currentPerson));
                }

            } catch (ApsentPersonInMetaDataException personIsApsentInMetaData) {
                System.out.println("You wrote incorrect name of person. Available persons: "
                        + PersonContainer.getAllAvailablePersonsFromFamilyForOperations());
            } catch (InccorectSpendTypeException e) {
            }

        }
        System.out.println("See you soon...");
    }

    private static void doSpendLogicNEED_RENAME(BufferedReader bufferedReader, Person currentPerson, SpendReceiver spendReceiver, String namePersonWhoSpendMoney) throws IOException, InccorectSpendTypeException {
        if (!spendReceiver.containsPerson(currentPerson)) {
            System.out.print("Write how much money " + currentPerson.getName() + " has now in the account: ");
            spendReceiver.addStartedIncome(currentPerson, Double.parseDouble(bufferedReader.readLine()));
        }
        System.out.println("Available spend types: ");
        for (String availableSpend : SpendsNameContainer.AVAILABLE_SPENDS()) {
            System.out.println(availableSpend + " ");
        }
        System.out.print("Write what type of spending will: ");
        String currentSpendType="";
//        while (!currentSpendType.equalsIgnoreCase("exit")) {
            currentSpendType = bufferedReader.readLine();
            if(currentSpendType.equalsIgnoreCase("quit")){
                throw new InccorectSpendTypeException("quit");
            }
            try{
                spendReceiver.verifyIfCurrentSpendTypeExist(currentSpendType);
//                break;
            }catch (InccorectSpendTypeException e){
                System.out.println("You wrote not exist spend type. Available spend types: ");
                for (String availableSpend : SpendsNameContainer.AVAILABLE_SPENDS()) {
                    System.out.println(availableSpend + " ");
                }
                System.out.print("Write one else what type of spending will: ");
                currentSpendType = bufferedReader.readLine();
                try{
                    spendReceiver.verifyIfCurrentSpendTypeExist(currentSpendType);
                }catch (InccorectSpendTypeException ex) {
                    throw new InccorectSpendTypeException("");
                }
            }
//        }
        System.out.print("Write how much will " + namePersonWhoSpendMoney + " spend: ");
        spendReceiver.addNewSpend(currentSpendType, Double.parseDouble(bufferedReader.readLine()), currentPerson);
    }
}
