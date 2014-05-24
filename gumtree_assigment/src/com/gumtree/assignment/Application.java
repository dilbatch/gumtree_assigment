package com.gumtree.assignment;

import com.gumtree.assignment.model.AddressBook;
import com.gumtree.assignment.model.Contact;
import com.gumtree.assignment.reader.FileReader;
import com.gumtree.assignment.reader.ReaderImpl;
import com.gumtree.assignment.util.OrderCriteria;
import com.gumtree.assignment.util.Orderable;
import com.gumtree.assignment.util.SearchCriteria;
import com.gumtree.assignment.util.Utils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class Application {
       public static void main(String[] args){
           ReaderImpl reader = new FileReader();
           List<Contact> list =  reader.readAddressBook("E:/gumtree_assigment/gumtree_assigment/resources/AddressBook");
//           for (Contact cont:list){
//               System.out.println(cont.getName());
//           }
           AddressBook addressBook = new AddressBook();
           addressBook.setContacts(list);

           SearchCriteria criteria = new SearchCriteria();
           criteria.setName("gender");
           criteria.setValue("Male");
           List<Object> result = addressBook.find(criteria);
//           for (Object obj:result){
//               Contact cont = (Contact) obj;
//               System.out.println(cont.getName() + "  " + cont.getGender() + " " + cont.getDate());
//           }
           System.out.println("Assignment");
           System.out.println("1. How many males are in the address book?");
           System.out.println("Answer: " + result.size());


           OrderCriteria orderCriteria = new OrderCriteria();
           orderCriteria.setName("date");
           orderCriteria.setOrderMode(Orderable.ASC);
           addressBook.orderBy(orderCriteria);
//           for (Contact cont:list){
//               System.out.println(cont.getName() + "  " + cont.getGender() + " " + cont.getDate());
//           }
           System.out.println("2. Who is the oldest person in the address book?");
           System.out.println("Answer: " + list.get(0).getName());

           Date billBirth = null,paulBirth = null;

           for (Contact cont:list){
               if (cont.getName().startsWith("Bill")){
                   billBirth = cont.getDate();
               }
               if (cont.getName().startsWith("Paul")){
                   paulBirth = cont.getDate();
               }

           }

           System.out.println("2. How many days older is Bill than Paul?");
           if (paulBirth != null && billBirth != null)
               System.out.println("Answer: " + Utils.getDateDiff(billBirth, paulBirth, TimeUnit.DAYS) + " days");
           else
               System.out.println("Answer: Either Bill or Paul is not in the list");

       }
}
