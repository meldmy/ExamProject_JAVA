package com.family_budget.family.fabric;

import com.family_budget.family.Person;
import com.family_budget.family.Father;
import com.family_budget.family.Mother;
import com.family_budget.family.Son;

import static com.family_budget.data.Metadate.*;

/**
 * Created by Dmytro Melnychuk on 28/05/16.
 */
public class PersonContainer {

    private static final Person father = new Father(FATHER_NAME);

    private static final Person mother = new Mother(MOTHER_NAME);

    private static final Person son = new Son(SON_NAME);

    public static Person receivePerson(String personName)throws ApsentPersonInMetaDataException
    {
        if(personName.equalsIgnoreCase(mother.getKeyForOperations()))
        {
            return mother;
        }else if (personName.equalsIgnoreCase(father.getKeyForOperations()))
        {
            return father;
        }else if (personName.equalsIgnoreCase(son.getKeyForOperations()))
        {
            return son;
        }else
        {
            throw new ApsentPersonInMetaDataException();
        }
    }

    public static String getAllAvailablePersonsFromFamilyForOperations()
    {
        return "\""+father.getKeyForOperations()+"\", \" "+mother.getKeyForOperations()+"\", \""+son.getKeyForOperations()+"\"";

    }
}
