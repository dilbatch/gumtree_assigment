package com.gumtree.assignment.reader;

import com.gumtree.assignment.exception.AssignmentException;
import com.gumtree.assignment.model.Contact;
import com.gumtree.assignment.util.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class FileReader implements ReaderImpl {

    @Override
    public List<Contact> readAddressBook(String path) {
        ArrayList<Contact> result = new ArrayList<Contact>();

        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(fis));

            String line = reader.readLine();
            int i = 0;
            while(line != null){
//                System.out.println(line);
                i++;
                String[] lineItems = line.split(",");
                if (lineItems.length != 3) throw new AssignmentException("Input file has not exact 3 elements on line i=" + i);
                Contact  contact = new Contact();
                if (lineItems[0] != null) contact.setName(lineItems[0].trim());
                if (lineItems[1] != null) contact.setGender(lineItems[1].trim());
                if (lineItems[2] != null) contact.setDate(Utils.getDateFromString(lineItems[2].trim()));
                result.add(contact);
                line = reader.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AssignmentException ex) {
           ex.printStackTrace();

        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                 ex.printStackTrace();
            }
        }
        return result;
    }
}
