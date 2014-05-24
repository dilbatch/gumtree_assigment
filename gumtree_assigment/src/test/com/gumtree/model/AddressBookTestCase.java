package test.com.gumtree.model;

import com.gumtree.assignment.model.AddressBook;
import com.gumtree.assignment.model.Contact;
import com.gumtree.assignment.util.SearchCriteria;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.com.gumtree.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dilyan B. on 14-5-24.
 */
public class AddressBookTestCase extends TestCase{
    private List<Contact> contacts1 = new ArrayList<Contact>();
    private List<Contact> contacts2 = new ArrayList<Contact>();

    @Before
    public void init(){
        Contact cont = new Contact();
        cont.setName("Name 1");
        cont.setGender("Male");
        Calendar cal = Calendar.getInstance();
        cal.set(2014,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        contacts1.add(cont);
        cont = new Contact();
        cont.setName("Name 2");
        cont.setGender("Female");
        cal.set(2012,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        contacts1.add(cont);


        cont = new Contact();
        cont.setName("Name 1");
        cont.setGender("Male");
        cal.set(2014,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        contacts2.add(cont);
        cont = new Contact();
        cont.setName("Name 2");
        cont.setGender("Female");
        cal.set(2012,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        contacts2.add(cont);
        cont = new Contact();
        cont.setName("Name 3");
        cont.setGender("Female");
        cal.set(2004,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        contacts2.add(cont);
    }

    @Test
    public void testFindSingleCriteria() throws Exception {
        init();
        AddressBook addressBook = new AddressBook();
        addressBook.setContacts(contacts1);

        Contact cont = new Contact();
        cont.setName("Name 1");
        cont.setGender("Male");
        Calendar cal = Calendar.getInstance();
        cal.set(2014,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        List<Object> expected = new ArrayList<Object>();
        expected.add(cont);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setName("gender");
        criteria.setValue("Male");
        List<Object> actual = addressBook.find(criteria);
        assertTrue(Utils.compareList(expected,actual));
    }

    @Test
    public void testFindMultipleCriteria() throws Exception {
        init();
        AddressBook addressBook = new AddressBook();
        addressBook.setContacts(contacts2);
        //Prepare expected result
        Contact cont = new Contact();
        cont.setName("Name 3");
        cont.setGender("Female");
        Calendar cal = Calendar.getInstance();
        cal.set(2004,1,14, 0,0,0);
        cal.set(Calendar.MILLISECOND,0);
        cont.setDate(cal.getTime());
        List<Object> expected = new ArrayList<Object>();
        expected.add(cont);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setName("gender");
        criteria.setValue("Female");

        SearchCriteria criteria2 = new SearchCriteria();
        criteria2.setName("date");
        criteria2.setValue(cal.getTime());
        List<Object> actual = addressBook.find(criteria, criteria2);
        assertTrue(Utils.compareList(expected,actual));
    }
}
