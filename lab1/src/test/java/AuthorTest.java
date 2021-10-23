import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    private Author testAuthor;
    private Name expectName;
    private String expectEmail;
    private Address expectAddress;

    @Before
    public void setUp() throws Exception {
        expectName = new Name("Zhuocai", "Tsai", "Li");
        expectEmail = "zhuocaili@neu.edu";
        expectAddress = new Address("5th Ave", "New York", "NY", "10021");
        testAuthor = new Author(expectName,expectEmail,expectAddress);
    }

    @Test
    public void getName() {
        assertEquals(expectName, testAuthor.getName());
    }

    @Test
    public void getEmailAddress() {
        assertEquals(expectEmail,testAuthor.getEmail());
    }

    @Test
    public void getAddress() {
        assertEquals(expectAddress, testAuthor.getAddress());
    }
}