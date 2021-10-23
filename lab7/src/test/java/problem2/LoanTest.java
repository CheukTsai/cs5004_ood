package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LoanTest {
  private Loan trackedLoan;
  private Loan trackedLoan2;
  private double previousInterest;
  private double currentInterest;
  private MSDailyFinances msDailyFinances;
  private MSDailyFinances msDailyFinances2;
  private String type;
  private double interest;
  private List<LoanObserver> observerList = new ArrayList<>();
  private Loan loan;
  private YFinances yFinances;
  private YFinances yFinances2;

  @Before
  public void setUp() throws Exception {
    type = "a";
    interest = 1.1;

    previousInterest = 1.2;
    currentInterest = 1.3;
    trackedLoan = new Loan(type,interest,observerList);
    msDailyFinances = new MSDailyFinances(trackedLoan,previousInterest,currentInterest);
    msDailyFinances2 = new MSDailyFinances(trackedLoan,5.5,currentInterest);

    currentInterest = 1.1;
    yFinances = new YFinances(currentInterest);
    yFinances2 = new YFinances(10.1);

    observerList.add(msDailyFinances);
    observerList.add(yFinances);

    loan = new Loan(type,interest,observerList);
    loan = new Loan(type,interest);

  }

  @Test
  public void getInterest() {
    assertEquals(interest,loan.getInterest(),0);

  }

  @Test
  public void setInterest() {
    trackedLoan.notifyObservers();
    trackedLoan.setInterest(2.5);

  }

  @Test
  public void testToString() {
    String expectedString =  "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';

    assertEquals(expectedString, loan.toString());
  }

  @Test
  public void registerObserver() {
    trackedLoan.registerObserver(msDailyFinances);
    trackedLoan.registerObserver(yFinances);

    trackedLoan.registerObserver(msDailyFinances2);
    trackedLoan.registerObserver(yFinances2);

  }

  @Test
  public void removeObserver() {
    trackedLoan.removeObserver(msDailyFinances);
    trackedLoan.removeObserver(yFinances);

  }

  @Test(expected = IllegalArgumentException.class)
  public void removeObserver2() throws IllegalArgumentException{
    trackedLoan.removeObserver(msDailyFinances2);
    trackedLoan.removeObserver(yFinances2);
  }


  @Test
  public void notifyObservers() {
    trackedLoan.notifyObservers();
  }
}