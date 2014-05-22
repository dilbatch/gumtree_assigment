package com.gumtree.assignment;

import com.gumtree.assignment.model.AddressBook;
import com.gumtree.assignment.model.Contact;
import com.gumtree.assignment.reader.FileReader;
import com.gumtree.assignment.reader.ReaderImpl;

import java.util.List;

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
