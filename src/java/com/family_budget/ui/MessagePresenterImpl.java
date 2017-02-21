package com.family_budget.ui;

import com.family_budget.family.Person;
import com.family_budget.family.fabric.PersonContainer;
import com.family_budget.spends.SpendController;


/**
 * @author Dmytro Melnychuk
 */
public class MessagePresenterImpl
                implements MessagePresenter
{
    @Override
    public void printQuestionAboutPerson()
    {
        System.out.print( "Write who making this operation: " );
    }


    @Override
    public void printStartInformation()
    {
        System.out.println(
                        "Program work till time that you enter word \"exit\" (without brackets)" );
        System.out.println(
                        "You can choose who current spend money. Available persons: " +
                                        PersonContainer.getAvailableInternalNames() );
    }


    @Override
    public void printAvailableOperations()
    {
        System.out.println(
                        "Choose operation type:\n1)New spend\n2)New income\n3)Get average spend sum\n4)Get current balance" );
    }


    @Override
    public void printQuestionAboutAccountBalance( String namePerson )
    {
        System.out.print( "Write how much will " + namePerson +
                        " adding to account: " );
    }


    @Override
    public void printPersonBalance( Person currentPerson )
    {
        System.out.println( SpendController.getInstance()
                        .currentBalanceInAccount( currentPerson ) );
    }


    @Override
    public void printIncorrectPersonNameInformation()
    {
        System.out.println(
                        "You wrote incorrect name of person. Available persons: " +
                                        getAvailableInternalPersonNames() );
    }


    @Override
    public void printExitMessage()
    {
        System.out.println( "See you soon..." );
    }


    private String getAvailableInternalPersonNames()
    {
        return PersonContainer.getAvailableInternalNames();
    }
}