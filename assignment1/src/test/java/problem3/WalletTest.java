package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WalletTest {

    private Name expectName;
    private Amount expectBalance;
    private Account expectAccount;
    private Wallet testWallet1;
    private Wallet testWallet2;
    private Wallet testWallet3;
    private Wallet testWallet4;


    @Before
    public void setUp() throws Exception {
        expectName = new Name("Zhuocai", "Li");
        expectBalance = new Amount(30,30);
        expectAccount = new Account(expectName, expectBalance);

    }

    @Test
    public void deposit() {
        testWallet1 = new Wallet(expectAccount);
        Amount amount1 = new Amount(20, 20);
        Account testAccount1 = testWallet1.deposit(amount1);
        Integer expectDollar1 = 50;
        Integer expectCent1 = 50;
        assertEquals(expectDollar1, testAccount1.getBalance().getDollar());
        assertEquals(expectCent1, testAccount1.getBalance().getCent());
        assertEquals(expectName, testAccount1.getName());

        testWallet2 = new Wallet(expectAccount);
        Amount amount2 = new Amount(20, 80);
        Integer expectDollar2 = 51;
        Integer expectCent2 = 10;
        Account testAccount2 = testWallet1.deposit(amount2);
        assertEquals(expectDollar2, testAccount2.getBalance().getDollar());
        assertEquals(expectCent2, testAccount2.getBalance().getCent());
        assertEquals(expectName, testAccount2.getName());

    }

    @Test
    public void withdraw() {
        testWallet3 = new Wallet(expectAccount);
        Amount amount3 = new Amount(20, 20);
        Account testAccount3 = testWallet3.withdraw(amount3);
        Integer expectDollar3 = 10;
        Integer expectCent3 = 10;
        assertEquals(expectDollar3, testAccount3.getBalance().getDollar());
        assertEquals(expectCent3, testAccount3.getBalance().getCent());
        assertEquals(expectName, testAccount3.getName());

        testWallet4 = new Wallet(expectAccount);
        Amount amount4 = new Amount(20, 40);
        Account testAccount4 = testWallet4.withdraw(amount4);
        Integer expectDollar4 = 9;
        Integer expectCent4 = 90;
        assertEquals(expectDollar4, testAccount4.getBalance().getDollar());
        assertEquals(expectCent4, testAccount4.getBalance().getCent());
        assertEquals(expectName, testAccount4.getName());
    }

    @Test
    public void getAccount() {
        testWallet1 = new Wallet(expectAccount);
        assertEquals(expectAccount, testWallet1.getAccount());
    }
}