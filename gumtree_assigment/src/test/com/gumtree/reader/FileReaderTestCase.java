package test.com.gumtree.reader;

import com.gumtree.assignment.exception.AssignmentException;
import com.gumtree.assignment.model.Contact;
import com.gumtree.assignment.reader.FileReader;
import junit.framework.TestCase;
import org.junit.Test;
import test.com.gumtree.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dilyan B. on 14-5-23.
 */
public class FileReaderTestCase extends TestCase {
    @Test(expected = AssignmentException.class)
    public void testReadAddressBookWrongDateFormat() throws Exception {
        FileReader reader = new FileReader();
        List<Contact> actual = reader.readAddressBook("E:/gumtree_assigment/gumtree_assigment/resources/testAddressBook_3");
    }

    @Test
    public void testReadAddressBookEmptyFile(){
        List<Contact> expected = new ArrayList<Contact>();
        FileReader reader = new FileReader();
        List<Contact> actual = reader.readAddressBook("E:/gumtree_assigment/gumtree_assigment/resources/testAddressBook_1");
        assertEquals(expected,actual);
    }

    @Test
    public void testReadAddressBook(){
        List<Contact> expected = new ArrayList<Contact>();
        Contact cont = new Contact();
        cont.setName("Name");
        cont.setGender("Male");
        Calendar cal = Calendar.getInstance();
        cal.set(2014,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        expected.add(cont);
        FileReader reader = new FileReader();
        List<Contact> actual = reader.readAddressBook("E:/gumtree_assigment/gumtree_assigment/resources/testAddressBook_4");
        assertTrue(Utils.compareList(expected, actual));
    }

    @Test(expected = AssignmentException.class)
    public void testReadAddressBookWrong() {
        FileReader reader = new FileReader();
        List<Contact> actual = reader.readAddressBook("E:/gumtree_assigment/gumtree_assigment/resources/testAddressBook_2");
    } 
    

}
