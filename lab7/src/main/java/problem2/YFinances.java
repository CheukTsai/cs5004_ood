package problem2;

import java.util.Objects;

/**
 * A class that represents a object of YFinances.
 */
public class YFinances implements LoanObserver{

  private double currentInterest;

  /**
   * A constructor that creates a new object of YFinances
   * @param currentInterest double
   */
  public YFinances(double currentInterest) {
    this.currentInterest = currentInterest;
  }

  /**
   * Return current interest
   * @return double
   */
  public double getCurrentInterest() {
    return currentInterest;
  }

  /**
   * Update the interest of the observableLoan
   * @param observableLoan Loan
   */
  @Override
  public void update(Loan observableLoan) {
    System.out.println("YFinances - updated interest rate - from " + this.currentInterest +
        "to" + observableLoan.getInterest());
    this.currentInterest = observableLoan.getInterest();
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
    YFinances yFinances = (YFinances) o;
    return Double.compare(yFinances.getCurrentInterest(), getCurrentInterest()) == 0;
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address.
   *
   * @return int, hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCurrentInterest());
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return int hash code
   */
  @Override
  public String toString() {
    return "YFinances{" +
        "currentInterest=" + currentInterest +
        '}';
  }
}

