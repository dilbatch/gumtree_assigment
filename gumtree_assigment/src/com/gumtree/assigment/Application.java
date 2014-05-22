package com.gumtree.assigment;

import com.gumtree.assigment.model.Contact;
import com.gumtree.assigment.reader.FileReader;
import com.gumtree.assigment.reader.ReaderImpl;
import com.sun.jndi.cosnaming.IiopUrl;

import java.util.List;
import java.util.prefs.Preferences;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class Application {
       public static void main(String[] args){
           ReaderImpl reader = new FileReader();
           List<Contact> list =  reader.readAddressBook();
           for (Contact cont:list){
               System.out.println(cont.getName());
           }
           AddressBook addressBook = new AddressBook();
           addressBook.setContacts(list);
       }
}
