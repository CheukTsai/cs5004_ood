import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OriginalAuthorTest {
    private OriginalAuthor testOriginalAuthor;
    private String expectName;
    private String expectEmail;
    private String expectAddress;

    @Before
    public void setUp() throws Exception {
        expectName = "Zhuocai Li";
        expectEmail = "zhuocaili@neu.edu";
        expectAddress = "New York, NY";
        testOriginalAuthor = new OriginalAuthor(expectName,expectEmail,expectAddress);
    }

    @Test
    public void getName() {
        assertEquals(expectName,testOriginalAuthor.getName());
    }

    @Test
    public void getEmail() {
        assertEquals(expectEmail,testOriginalAuthor.getEmail());
    }

    @Test
    public void getAddress() {
        assertEquals(expectAddress,testOriginalAuthor.getAddress());
    }
}