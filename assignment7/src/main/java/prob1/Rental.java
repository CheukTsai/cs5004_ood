package prob1;

import java.util.Objects;

/**
 * Represents an concrete class Rental, extending its parent class Contract
 */
public class Rental extends Contract {

  private Integer term;

  /**
   * Constructs a Rental
   *
   * @param askingPrice  the asking price of the Rental Contract
   * @param isNegotiable whether the Rental Contract is negotiable
   * @param term         the length of the Rental
   */
  public Rental(Double askingPrice, Boolean isNegotiable, Integer term) {
    super(askingPrice, isNegotiable);
    this.term = term;
    this.checkInfo();
  }

  /**
   * Checks if arguments is valid
   */
  private void checkInfo() {
    if (this.term <= 0) {
      throw new IllegalArgumentException("Illegal number of terms");
    }
  }

  /**
   * Returns the term of the Rental
   *
   * @return the term of the Rental
   */
  public Integer getTerm() {
    return term;
  }

  /**
   * {@inheritDoc} Indicates whether some other object passed as an argument is "equal to" the
   * Rental
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (!(o instanceof Rental)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(term, rental.term);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), term);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString() + "Rental{" + "term=" + term + '}';
  }

  /**
   * {@inheritDoc} Helper, returns commission factor for calculating commission
   *
   * @return commission factor
   */
  @Override
  protected Integer getCommissionFactor() {
    return this.term;
  }
}


