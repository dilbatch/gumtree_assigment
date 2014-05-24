package com.gumtree.assignment.model;

import com.gumtree.assignment.util.SearchCriteria;
import com.gumtree.assignment.util.Searchable;
import com.gumtree.assignment.util.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class AddressBook implements Searchable {
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public List<Object> find(SearchCriteria... searchCriteria) {
        List<Object> result = new ArrayList<Object>();
        Class clazz =  Contact.class;
        int match;
        for (Contact contact : contacts){
            match = 0;
            for(SearchCriteria element : searchCriteria) {
                try {
                    Method getMethod = clazz.getMethod(Utils.createGetterNameFrom(element.getName()));
                    Object returnValue = getMethod.invoke(contact);
                    Class returnType = getMethod.getReturnType();
//                    if (element.getValue().getClass() instanceof returnType){
//
//                    }
                    if (element.getValue().equals(returnValue)) {
                        match++;
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (match == searchCriteria.length)  result.add(contact);
        }
        return result;
    }
}
