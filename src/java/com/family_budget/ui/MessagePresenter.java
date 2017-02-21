package com.family_budget.ui;

import com.family_budget.family.Person;


/**
 * @author Dmytro Melnychuk
 */
public interface MessagePresenter
{

    void printQuestionAboutPerson();

    void printStartInformation();

    void printAvailableOperations();

    void printQuestionAboutAccountBalance( String namePerson );

    void printPersonBalance( Person currentPerson );

    void printIncorrectPersonNameInformation();

    void printExitMessage();
}
