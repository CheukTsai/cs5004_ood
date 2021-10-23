package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a concrete class OneTimeDonation, extending its parent class Donation
 */
public class OneTimeDonation extends Donation{

  private LocalDateTime donationTime;
  private Float amount;

  /**
   * Constructs a new OneTimeDonation, with donationTime and the amount of donation
   * @param donationTime - LocalDateTime, time when donation is created
   * @param amount - Float, the amount of donation
   */
  public OneTimeDonation(LocalDateTime donationTime, Float amount) {
    this.donationTime = donationTime;
    this.amount = amount;
  }

  /**
   * {@inheritDoc}
   * Overrides countYearlyAmount() method
   * @param year - Integer, the year for calculation
   * @return Float
   */
  @Override
  public Float countYearlyAmount(Integer year) {
    if(this.donationTime.getYear() == year) return this.amount;
    return 0f;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OneTimeDonation that = (OneTimeDonation) o;
    return Objects.equals(donationTime, that.donationTime) && Objects
        .equals(amount, that.amount);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(donationTime, amount);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "OneTimeDonation{" +
        "donationTime=" + donationTime +
        ", amount=" + amount +
        '}';
  }
}
