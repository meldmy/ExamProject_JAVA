package com.family_budget;

import com.family_budget.family.Person;
import com.family_budget.family.fabric.PersonContainer;
import com.family_budget.family.fabric.IncorrectPersonName;
import com.family_budget.spends.InccorectSpendTypeException;
import com.family_budget.spends.SpendController;
import com.family_budget.spends.SpendsNameContainer;
import com.family_budget.ui.MessangePresenter;
import com.family_budget.ui.MessangePresenterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.family_budget.Operations.*;


/**
 * @author Dmytro Melnychuk
 */
public class WorkflowCli
{

    private static MessangePresenter messenger;
    private static SpendController spendController;
    private static BufferedReader bufferedReader;


    public static void main( String[] args ) throws IOException
    {
        initializeFields();
        messenger.printStartInformation();
        try
        {
            startClientOperations();
        }
        catch( ExitException e )
        {
            messenger.printExitMessage();
            System.exit( 0 );
        }
    }


    private static void initializeFields()
    {
        messenger = new MessangePresenterImpl();
        spendController = SpendController.getInstance();
        bufferedReader = new BufferedReader(
                        new InputStreamReader( System.in ) );
    }


    private static void startClientOperations()
                    throws IOException, ExitException
    {
        Person currentPerson;
        String namePerson = EMPTY;
        while( !namePerson.equals( EXIT ) )
        {
            messenger.printQuestionAboutPerson();
            namePerson = bufferedReader.readLine();

            currentPerson = receivePerson( namePerson );
            if( isReceivedPerson( currentPerson ) )
                chooseOperation( currentPerson );
        }
    }


    private static boolean isReceivedPerson( Person currentPerson )
    {
        return currentPerson != null;
    }


    private static Person receivePerson( String namePerson )
                    throws ExitException
    {
        Person currentPerson = null;
        try
        {
            currentPerson = PersonContainer.receivePerson( namePerson );
        }
        catch( IncorrectPersonName incorrectPersonName )
        {
            if( !namePerson.equals( EXIT ) )
                messenger.printIncorrectPersonNameInformation();
            else
            {
                throw new ExitException();
            }
        }
        return currentPerson;
    }


    private static void chooseOperation( Person currentPerson )
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
            System.out.print( "Write how much money " +
                            currentPerson.getFirstName() +
                            " has now in the account: " );
            spendController.addStartedIncome( currentPerson,
                            Double.parseDouble( bufferedReader.readLine() ) );
        }
        System.out.println( "Available spend types: " );
        for( String availableSpend : SpendsNameContainer.AVAILABLE_SPENDS() )
        {
            System.out.println( availableSpend + " " );
        }
        System.out.print( "Write what type of spending will: " );
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
            System.out.println(
                            "You wrote not exist spend type. Available spend types: " );
            for( String availableSpend : SpendsNameContainer
                            .AVAILABLE_SPENDS() )
            {
                System.out.println( availableSpend + " " );
            }
            System.out.print( "Write one else what type of spending will: " );
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
        System.out.print( "Write how much will " +
                        currentPerson.getInternalName() + " spend: " );
        spendController.addNewSpend( currentSpendType,
                        Double.parseDouble( bufferedReader.readLine() ),
                        currentPerson );
    }
}
