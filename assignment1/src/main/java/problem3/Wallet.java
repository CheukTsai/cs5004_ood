package problem3;

/*** Wallet is an object that has a unique
 * account. */
public class Wallet {

  public static final Integer BASE_HUNDRED = 100;
  private Account account;

  /**
   * Constructor that creates a new Wallet object with the specified account.
   *
   * @param account - account of the new Wallet object.
   */
  public Wallet(Account account) {
    this.account = account;
  }

  /**
   * Deposits specified amount into the account.
   *
   * @param amount - amount of deposit.
   * @return new Account with specified Name and Amount.
   */
  public Account deposit(Amount amount) {
    Name name = account.getName();
    Amount balance = account.getBalance();
    Integer dollar = balance.getDollar();
    Integer cent = balance.getCent();
    Integer outDollar = dollar + amount.getDollar();
    Integer outCent = cent + amount.getCent();
    if (cent + amount.getCent() >= BASE_HUNDRED) {
      outCent -= BASE_HUNDRED;
      outDollar += 1;
    }
    Amount outBalance = new Amount(outDollar, outCent);
    Account newAccount = new Account(name, outBalance);
    return newAccount;
  }

  /**
   * Withdraws specified amount from the account.
   *
   * @param amount - amount of withdrawal.
   * @return new Account with specified Name and Amount.
   */
  public Account withdraw(Amount amount) {
    Name name = account.getName();
    Amount balance = account.getBalance();
    Integer dollar = balance.getDollar();
    Integer cent = balance.getCent();
    Integer outDollar = dollar - amount.getDollar();
    Integer outCent = cent - amount.getCent();
    if (cent < amount.getCent()) {
      outCent += BASE_HUNDRED;
      outDollar -= 1;
    }
    Amount outBalance = new Amount(outDollar, outCent);
    Account newAccount = new Account(name, outBalance);
    return newAccount;
  }

  /**
   * Returns the account of the Wallet.
   *
   * @return the account of the Wallet.
   */
  public Account getAccount() {
    return account;
  }
}
