package problem2;

import java.util.Objects;

/**
 * A class that is ued to represent a object of LoanObserver
 */
public class MSDailyFinances implements LoanObserver{
  private Loan trackedLoan;
  private double previousInterest;
  private double currentInterest;

  /**
   * A constructor that can create a new obejct
   * @param trackedLoan - Loan trackedLoan
   * @param previousInterest - double previousInterest
   * @param currentInterest - double currentInterest
   */
  public MSDailyFinances(Loan trackedLoan, double previousInterest, double currentInterest) {
    this.trackedLoan = trackedLoan;
    this.previousInterest = previousInterest;
    this.currentInterest = currentInterest;
  }

  /**
   * Return tracked loan
   * @return Loan
   */
  public Loan getTrackedLoan() {
    return trackedLoan;
  }

  /**
   * Return previous interest
   * @return double
   */
  public double getPreviousInterest() {
    return previousInterest;
  }

  /**
   * Return current interest
   * @return double
   */
  public double getCurrentInterest() {
    return currentInterest;
  }

  /**
   * Update the interest of Loan
   * @param loan
   */
  @Override
  public void update(Loan loan) {
    if(this.trackedLoan.equals(loan)){
      this.previousInterest = this.currentInterest;
      this.currentInterest = loan.getInterest();
      System.out.println("Loan interest change alert - updated interest: " + this.currentInterest +
          "rate of change " + this.currentInterest/this.previousInterest);
    }
    else throw new IllegalArgumentException("Not a tracked loan!");
  }

  /**
   * {@inheritDoc}
   * Indicates whether some other object passed as an argument is "equal to" the
   * current instance.
   *
   * @param o - an object to compare
   * @return boolean value
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MSDailyFinances that = (MSDailyFinances) o;
    return Double.compare(that.getPreviousInterest(), getPreviousInterest()) == 0
        && Double.compare(that.getCurrentInterest(), getCurrentInterest()) == 0
        && Objects.equals(getTrackedLoan(), that.getTrackedLoan());
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address.
   *
   * @return int, hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTrackedLoan(), getPreviousInterest(), getCurrentInterest());
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object
   *
   * @return int hash code
   */
  @Override
  public String toString() {
    return "MSDailyFinances{" +
        "trackedLoan=" + trackedLoan +
        ", previousInterest=" + previousInterest +
        ", currentInterest=" + currentInterest +
        '}';
  }
}
