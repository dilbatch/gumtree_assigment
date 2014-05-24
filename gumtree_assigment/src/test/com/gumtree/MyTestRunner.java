package test.com.gumtree;

/**
 * Created by Dilyan B. on 14-5-24.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.com.gumtree.model.AddressBookTestCase;
import test.com.gumtree.reader.FileReaderTestCase;

public class MyTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FileReaderTestCase.class, AddressBookTestCase.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}