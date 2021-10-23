import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class ViewUtilsTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test(expected = NoSuchElementException.class)
  public void getInput() {
    ViewUtils.getInput("a");
  }

}