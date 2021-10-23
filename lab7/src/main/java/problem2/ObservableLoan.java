package problem2;

/**
 * An interface that represent an object of ObservableLoan.
 */
public interface ObservableLoan {

  /**
   * Register observer
   * @param observer LoanObserver
   */
  void registerObserver(LoanObserver observer);

  /**
   * Remove observer
   * @param observer LoanObserver
   */
  void removeObserver(LoanObserver observer);

  /**
   * A helper method that is used to notice the observers once the interest has changed.
   */
  void notifyObservers();

}
