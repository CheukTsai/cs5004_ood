package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner testOwner1;
    private Owner testOwner2;
    private Owner testOwner3;
    private String expectFirstName;
    private String expectLastName;
    private String expectPhoneNumber;
    private String expectPhoneNumberInvalid;
    private String expectPhoneNumberInvalid2;

    @Before
    public void setUp() throws Exception {
        expectFirstName = "Zhuocai";
        expectLastName = "Li";
        expectPhoneNumber = "4432550275";
        expectPhoneNumberInvalid = "4432550A75";
        expectPhoneNumberInvalid2 = "12345678901";
        testOwner1 = new Owner(expectFirstName,expectLastName,expectPhoneNumber);
        testOwner2 = new Owner(expectFirstName,expectLastName,expectPhoneNumberInvalid);
        testOwner3 = new Owner(expectFirstName,expectLastName,expectPhoneNumberInvalid2);
    }

    @Test
    public void verifyPhoneNumber() {
        assertEquals(true, testOwner1.verifyPhoneNumber(expectPhoneNumber));
        assertEquals(false, testOwner2.verifyPhoneNumber(expectPhoneNumberInvalid));
        assertEquals(false, testOwner3.verifyPhoneNumber(expectPhoneNumberInvalid2));

    }

    @Test
    public void getFirstName() {
        assertEquals(expectFirstName, testOwner1.getFirstName());
        assertEquals(expectFirstName, testOwner2.getFirstName());
        assertEquals(expectFirstName, testOwner3.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(expectLastName, testOwner1.getLastName());
        assertEquals(expectLastName, testOwner2.getLastName());
        assertEquals(expectLastName, testOwner3.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(expectPhoneNumber, testOwner1.getPhoneNumber());
        assertEquals(null, testOwner2.getPhoneNumber());
        assertEquals(null, testOwner3.getPhoneNumber());
    }


}