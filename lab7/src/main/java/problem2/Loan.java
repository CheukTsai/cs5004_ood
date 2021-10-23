package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class that represents a object of Loan
 */
public class Loan implements ObservableLoan{
  private String type;
  private double interest;
  private List<LoanObserver> observerList = new ArrayList<>();

  /**
   * A constructor that create a new object of Loan
   * @param type - String,
   * @param interest - interest
   */
  public Loan(String type, double interest) {
    this.type = type;
    this.interest = interest;
  }

  /**
   * A constructor that create a new object of Loan
   * @param type - String
   * @param interest - double
   * @param observerList - List<LoanObserver>
   */
  public Loan(String type, double interest, List<LoanObserver> observerList) {
    this.type = type;
    this.interest = interest;
    this.observerList = observerList;
  }

  /**
   * Return interest
   * @return interest
   */
  public double getInterest() {
    return interest;
  }

  /**
   * Set interest
   * @param interest double
   */
  public void setInterest(double interest) {
    this.interest = interest;
    notifyObservers();
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object.
   *
   * @return int hash code
   */
  @Override
  public String toString() {
    return "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';
  }

  /**
   * Register observer method
   * @param observer
   */
  @Override
  public void registerObserver(LoanObserver observer) {
    if(!observerList.contains(observer))
      observerList.add(observer);
  }

  /**
   * Remove observer from observerList
   * @param observer LoanObserver
   */
  @Override
  public void removeObserver(LoanObserver observer) {
    if(observerList.contains(observer))
      observerList.remove(observer);
    else throw new IllegalArgumentException("Observer not found!");
  }

  /**
   * A helper function that used to update the observer from the observer list
   */
  @Override
  public void notifyObservers() {
    for(LoanObserver observer: this.observerList){
      observer.update(this);
    }
  }
}
