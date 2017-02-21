package com.family_budget;

import com.family_budget.family.Person;
import com.family_budget.family.fabric.IncorrectPersonName;
import com.family_budget.family.fabric.PersonContainer;
import com.family_budget.spends.InccorectSpendTypeException;
import com.family_budget.spends.SpendController;
import com.family_budget.spends.SpendsNameContainer;
import com.family_budget.ui.MessagePresenter;
import com.family_budget.ui.MessagePresenterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static com.family_budget.Operations.*;
import static java.lang.System.in;
import static java.lang.System.out;


/**
 * @author Dmytro Melnychuk
 */
public class WorkflowCli
{
    private static MessagePresenter messenger;
    private static SpendController spendController;
    private static BufferedReader bufferedReader;


    public static void main( String[] args ) throws IOException
    {
        initializeFields();
        messenger.printStartInformation();
        boolean isUserWantToExit;
        do
        {
            isUserWantToExit = startUserActivity();
        }while( isUserWantToExit );
    }


    private static boolean startUserActivity()
    {
        boolean isExitOperation;
        try
        {
            String namePerson = readUserName();
            isExitOperation = !isChoosenExit( namePerson );
            startPersonActivity( namePerson );
        }
        catch( IOException e )
        {
            messenger.printExitMessage();
            isExitOperation = false;
        }
        return isExitOperation;
    }


    private static void initializeFields()
    {
        messenger = new MessagePresenterImpl();
        spendController = SpendController.getInstance();
        bufferedReader = new BufferedReader( new InputStreamReader( in ) );
    }


    private static String readUserName() throws IOException
    {
        messenger.printQuestionAboutPerson();
        return bufferedReader.readLine();
    }


    private static boolean startPersonActivity( String namePerson )
                    throws IOException
    {
        Optional<Person> currentPerson = receivePerson( namePerson );
        if( currentPerson.isPresent() )
            chooseUserOperation( currentPerson.get() );
        return true;
    }


    private static Optional<Person> receivePerson( String typedUserName )
    {
        try
        {
            return Optional.of( PersonContainer.receivePerson( typedUserName ) );
        }
        catch( IncorrectPersonName incorrectPersonName )
        {
            messenger.printIncorrectPersonNameInformation();
            return Optional.empty();
        }
    }


    private static boolean isChoosenExit( String typedUserName )
    {
        return typedUserName.equals( EXIT );
    }


    private static void chooseUserOperation( Person currentPerson )
                    throws IOException
    {
        String operationName;

        try
        {
            messenger.printAvailableOperations();
            operationName = bufferedReader.readLine();
            if( operationName.equalsIgnoreCase( SPEND ) ||
                            operationName.contains( SPEND_NUMBER ) )
            {
                createNewSpend( bufferedReader, currentPerson,
                                spendController );
            }
            else if( operationName.equalsIgnoreCase( INCOME ) ||
                            operationName.startsWith( INCOME_NUMBER ) )
            {
                messenger.printQuestionAboutAccountBalance(
                                currentPerson.getInternalName() );

                spendController.addNewIncome(
                                currentPerson, Double.parseDouble(
                                                bufferedReader.readLine() ) );
            }
            else if( (operationName.equalsIgnoreCase( AVERAGE ) ||
                            operationName.startsWith( AVERAGE_NUMBER )) )
            {
                spendController.printAverageSpendSumsByType( currentPerson );
            }
            else if( (operationName.equalsIgnoreCase( CURRENT ) ||
                            operationName.equalsIgnoreCase( BALANCE ) ||
                            operationName.startsWith( BALANCE_NUMBER )) )
            {
                messenger.printPersonBalance( currentPerson );
            }
        }
        catch( InccorectSpendTypeException e )
        {
        }
    }


    private static void createNewSpend(
                    BufferedReader bufferedReader,
                    Person currentPerson,
                    SpendController spendController )
                    throws IOException, InccorectSpendTypeException
    {
        if( !spendController.containsPerson( currentPerson ) )
        {
            out.print( "Write how much money " + currentPerson.getFirstName() +
                            " has now in the account: " );
            spendController.addStartedIncome( currentPerson,
                            Double.parseDouble( bufferedReader.readLine() ) );
        }
        out.println( "Available spend types: " );
        for( String availableSpend : SpendsNameContainer.AVAILABLE_SPENDS() )
        {
            out.println( availableSpend + " " );
        }
        out.print( "Write what type of spending will: " );
        String currentSpendType = "";
        currentSpendType = bufferedReader.readLine();
        if( currentSpendType.equalsIgnoreCase( "quit" ) )
        {
            throw new InccorectSpendTypeException( "quit" );
        }
        try
        {
            spendController.verifyIfCurrentSpendTypeExist( currentSpendType );
        }
        catch( InccorectSpendTypeException e )
        {
            out.println( "You wrote not exist spend type. Available spend types: " );
            for( String availableSpend : SpendsNameContainer
                            .AVAILABLE_SPENDS() )
            {
                out.println( availableSpend + " " );
            }
            out.print( "Write one else what type of spending will: " );
            currentSpendType = bufferedReader.readLine();
            try
            {
                spendController.verifyIfCurrentSpendTypeExist(
                                currentSpendType );
            }
            catch( InccorectSpendTypeException ex )
            {
                throw new InccorectSpendTypeException( "" );
            }
        }
        out.print( "Write how much will " + currentPerson.getInternalName() +
                        " spend: " );
        spendController.addNewSpend( currentSpendType,
                        Double.parseDouble( bufferedReader.readLine() ),
                        currentPerson );
    }
}
