package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class YFinancesTest {
  private double currentInterest;
  private YFinances yFinances;

  private String type;
  private double interest;
  private List<LoanObserver> observerList = new ArrayList<>();
  private Loan loan;

  private double currentInterest2;
  private YFinances yFinances2;

  @Before
  public void setUp() throws Exception {
    currentInterest = 1.1;
    yFinances = new YFinances(currentInterest);
    type = "a";
    interest = 1.1;

    observerList.add(yFinances);
    loan = new Loan(type,interest,observerList);
  }

  @Test
  public void getCurrentInterest() {
    assertEquals(currentInterest,yFinances.getCurrentInterest(),0);

  }

  @Test
  public void update() {
    yFinances.update(loan);

  }

  @Test
  public void testEquals() {
    assertTrue(yFinances.equals(yFinances));
    assertNotEquals(yFinances,null);
    assertFalse(yFinances.equals(currentInterest));

    yFinances2 = new YFinances(currentInterest);
    assertTrue(yFinances.equals(yFinances2));

    yFinances2 = new YFinances(2.5);
    assertFalse(yFinances.equals(yFinances2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(currentInterest);
    assertEquals(yFinances.hashCode(),hash);
  }

  @Test
  public void testToString() {
    String expectedString = "YFinances{" +
        "currentInterest=" + currentInterest +
        '}';
    assertEquals(yFinances.toString(),expectedString);
  }
}