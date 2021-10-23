package problem3;

/*** Amount is a simple object that has a unique
 * dollar, and cent. */
public class Amount {
  public static final Integer BASE_HUNDRED = 100;
  private Integer dollar;
  private Integer cent;

  /**
   * Constructor that creates a new Amount object with the specified dollar and cent.
   *
   * @param dollar - dollar of the new Amount.
   * @param cent - cent of the new Amount.
   */
  public Amount(Integer dollar, Integer cent) {
    if (dollar < 0) {
      System.out.println("Input dollar is invalid");
    } else {
      this.dollar = dollar;
    }
    if (cent < 0 || cent >= BASE_HUNDRED) {
      System.out.println("Input cent is invalid");
    } else {
      this.cent = cent;
    }
  }

  /**
   * Returns the dollar of the Amount.
   *
   * @return the dollar of the Amount.
   */
  public Integer getDollar() {
    return dollar;
  }

  /**
   * Returns the cent of the Amount.
   *
   * @return the cent of the Amount.
   */
  public Integer getCent() {
    return cent;
  }
}
