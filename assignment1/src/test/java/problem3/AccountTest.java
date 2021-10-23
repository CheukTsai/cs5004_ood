package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Name expectName;
    private Amount expectBalance;
    private Account testAccount;

    @Before
    public void setUp() throws Exception {
        expectName = new Name("Zhuocai", "Li");
        expectBalance = new Amount(20,20);
        testAccount = new Account(expectName, expectBalance);
    }

    @Test
    public void getName() {
        assertEquals(expectName, testAccount.getName());
    }

    @Test
    public void getBalance() {
        assertEquals(expectBalance, testAccount.getBalance());
    }
}