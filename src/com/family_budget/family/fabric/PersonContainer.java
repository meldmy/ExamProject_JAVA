package com.family_budget.family.fabric;

import com.family_budget.family.Person;
import com.family_budget.family.Father;
import com.family_budget.family.Mother;
import com.family_budget.family.Son;

import static com.family_budget.data.Metadate.*;


/**
 * @author Dmytro Melnychuk
 */
public class PersonContainer
{

    private static final Person father = new Father( FATHER_NAME );

    private static final Person mother = new Mother( MOTHER_NAME );

    private static final Person son = new Son( SON_NAME );


    public static Person receivePerson( String personName )
                    throws IncorrectPersonName
    {
        if( personName.equalsIgnoreCase( mother.getInternalName() ) )
        {
            return mother;
        }
        else if( personName.equalsIgnoreCase( father.getInternalName() ) )
        {
            return father;
        }
        else if( personName.equalsIgnoreCase( son.getInternalName() ) )
        {
            return son;
        }
        else
        {
            throw new IncorrectPersonName();
        }
    }


    public static String getAvailableInternalNames()
    {
        return "\"" + father.getInternalName() + "\", \" " +
                        mother.getInternalName() + "\", \"" +
                        son.getInternalName() + "\"";

    }
}
