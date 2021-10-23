package problem3;

/*** Amount is an object that has a unique
 * name and balance. */
public class Account {

  private Name name;
  private Amount balance;

  /**
   * Constructor that creates a new Account object with the specified name and balance.
   *
   * @param name - name of the new Account object.
   * @param balance - balance of the new Account.
   */
  public Account(Name name, Amount balance) {
    this.name = name;
    this.balance = balance;
  }

  /**
   * Returns the name of the Account.
   *
   * @return the name of the Account.
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns the balance of the Account.
   *
   * @return the balance of the Account.
   */
  public Amount getBalance() {
    return balance;
  }
}
