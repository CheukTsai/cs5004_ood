package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a concrete class MonthlyDonation, extending its parent class Donation
 */
public class MonthlyDonation extends Donation{

  private Float monthlyAmount;
  private LocalDateTime subscriptionTime;
  private LocalDateTime cancellationTime;
  private static final Integer MONTHS_IN_A_YEAR = 12;

  /**
   * Constructs a new MonthlyAmount, with monthlyAmount and subscriptionTime
   * @param monthlyAmount - Float, amount of monthly donation
   * @param subscriptionTime - LocalDateTime, time of monthly subscription
   */
  public MonthlyDonation(Float monthlyAmount, LocalDateTime subscriptionTime) {
    this.monthlyAmount = monthlyAmount;
    this.subscriptionTime = subscriptionTime;
    this.cancellationTime = null;
  }

  /**
   * Sets the cancellation date of the monthly donation
   * @param cancellationTime - - LocalDateTime, time when monthly subscription is cancelled
   * @throws InvalidCancellationDateException - thrown when cancellation date is
   * earlier than subscription date
   */
  public void setCancellationTime(LocalDateTime cancellationTime)
      throws InvalidCancellationDateException {
    if(cancellationTime.isBefore(subscriptionTime)) throw new InvalidCancellationDateException();
    this.cancellationTime = cancellationTime;
  }

  /**
   * {@inheritDoc}
   * Overrides countYearlyAmount() method
   * @param year - Integer, the year for calculation
   * @return Float
   */
  @Override
  public Float countYearlyAmount(Integer year) {
    return countValidMonths(year) * monthlyAmount;
  }

  /**
   * Checks if the monthly donation is charged in the Month of cancellation month
   * @return Boolean
   */
  private Boolean isChargeHappensLastMonth(){
    if(cancellationTime.getDayOfMonth() > subscriptionTime.getDayOfMonth()) return true;
    else if(cancellationTime.getDayOfMonth() < subscriptionTime.getDayOfMonth()) return false;
    else{
      if(cancellationTime.getHour() > subscriptionTime.getHour()) return true;
      else if(cancellationTime.getHour() < subscriptionTime.getHour()) return false;
      else{
        if (cancellationTime.getMinute() > subscriptionTime.getMinute()) return true;
        else if (cancellationTime.getMinute() < subscriptionTime.getMinute()) return false;
        else{
          if(cancellationTime.getSecond() >= subscriptionTime.getSecond()) return true;
          else return false;
        }
      }
    }
  }

  /**
   * Helper, sums up months when subscription is charged in a specific year
   * @param targetYear - Integer, target year to be calculated
   * @return Integer
   */
  private Integer countValidMonths(Integer targetYear){
    Integer output = 0;

    if(subscriptionTime.getYear() < targetYear) output -= 0;
    else if(subscriptionTime.getYear() == targetYear) output -= subscriptionTime.getMonthValue() - 1;
    else output -= MONTHS_IN_A_YEAR;

    if(cancellationTime == null || cancellationTime.getYear() > targetYear) {
      output += MONTHS_IN_A_YEAR;}
    else if(cancellationTime.getYear() == targetYear) {
      output += cancellationTime.getMonthValue() ;
      output -= isChargeHappensLastMonth() ? 0 : 1;
    }
    else output += 0;

    return output;
  }

  /**
   * Returns the amount of monthly subscription
   * @return Float
   */
  public Float getMonthlyAmount() {
    return monthlyAmount;
  }

  /**
   * Returns the subscription time
   * @return LocalDateTime
   */
  public LocalDateTime getSubscriptionTime() {
    return subscriptionTime;
  }

  /**
   * Returns the cancellation time
   * @return LocalDateTime
   */
  public LocalDateTime getCancellationTime() {
    return cancellationTime;
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
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(monthlyAmount, that.monthlyAmount) && Objects
        .equals(subscriptionTime, that.subscriptionTime) && Objects
        .equals(cancellationTime, that.cancellationTime);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(monthlyAmount, subscriptionTime, cancellationTime);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "monthlyAmount=" + monthlyAmount +
        ", subscriptionTime=" + subscriptionTime +
        ", cancellationTime=" + cancellationTime +
        '}';
  }
}

