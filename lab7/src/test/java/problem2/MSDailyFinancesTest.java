package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class MSDailyFinancesTest {
  private Loan trackedLoan;
  private Loan trackedLoan2;
  private double previousInterest;
  private double currentInterest;
  private MSDailyFinances msDailyFinances;
  private MSDailyFinances msDailyFinances2;

  private String type;
  private double interest;
  private List<LoanObserver> observerList = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    type = "a";
    interest = 1.1;
    previousInterest = 1.2;
    currentInterest = 1.3;
    trackedLoan = new Loan(type,interest,observerList);
    msDailyFinances = new MSDailyFinances(trackedLoan,previousInterest,currentInterest);
    observerList.add(msDailyFinances);

  }

  @Test
  public void getTrackedLoan() {
    assertEquals(trackedLoan,msDailyFinances.getTrackedLoan());
  }

  @Test
  public void getPreviousInterest() {
    assertEquals(previousInterest,msDailyFinances.getPreviousInterest(),0);
  }

  @Test
  public void getCurrentInterest() {
    assertEquals(currentInterest,msDailyFinances.getCurrentInterest(),0);
  }

  @Test
  public void update() {
    assertTrue(trackedLoan.equals(msDailyFinances.getTrackedLoan()));
  }

  @Test
  public void testEquals() {
    assertTrue(msDailyFinances.equals(msDailyFinances));
    assertNotEquals(msDailyFinances,null);
    assertFalse(msDailyFinances.equals(interest));

    msDailyFinances2 = new MSDailyFinances(trackedLoan,previousInterest,currentInterest);
    assertTrue(msDailyFinances.equals(msDailyFinances2));

    msDailyFinances2 = new MSDailyFinances(trackedLoan,5.5,currentInterest);
    assertFalse(msDailyFinances.equals(msDailyFinances2));

    msDailyFinances2 = new MSDailyFinances(trackedLoan, previousInterest,5.5);
    assertFalse(msDailyFinances.equals(msDailyFinances2));

    trackedLoan2 = new Loan("b",interest,observerList);
    msDailyFinances2 = new MSDailyFinances(trackedLoan2, previousInterest,currentInterest);
    assertFalse(msDailyFinances.equals(msDailyFinances2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(trackedLoan,previousInterest,currentInterest);
    assertEquals(msDailyFinances.hashCode(),hash);
  }

  @Test
  public void testToString() {
    String expectedString = "MSDailyFinances{" +
        "trackedLoan=" + trackedLoan +
        ", previousInterest=" + previousInterest +
        ", currentInterest=" + currentInterest +
        '}';

    assertEquals(expectedString,msDailyFinances.toString());
  }
}