package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a concrete class Pledge, extending its parent class Donation
 */
public class Pledge extends Donation{
  private LocalDateTime creationTime;
  private Float amount;
  private LocalDateTime processTime;

  /**
   * Constructs a new Pledge, with creationTime and amount
   * @param creationTime - LocalDateTime, time when pledge is created
   * @param amount - Float, the amount of donation
   */
  public Pledge(LocalDateTime creationTime, Float amount) {
    this.creationTime = creationTime;
    this.amount = amount;
    this.processTime = null;
  }

  /**
   * Constructs a new Pledge, with creationTime, amount, and processTime
   * @param creationTime - LocalDateTime, time when pledge is created
   * @param amount - Float, the amount of donation
   * @param processTime - LocalDateTime, time when pledge is or is going to be processed
   * @exception InvalidProcessingTimeException - thrown when processing date is
   * earlier than creation date
   */
  public Pledge(LocalDateTime creationTime,Float amount, LocalDateTime processTime)
  throws InvalidProcessingTimeException{
    if(processTime.isBefore(creationTime)) throw new InvalidProcessingTimeException();
    this.creationTime = creationTime;
    this.processTime = processTime;
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
    if (this.processTime == null || this.processTime.getYear() != year) return 0f;
    return amount;
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
    Pledge pledge = (Pledge) o;
    return Objects.equals(creationTime, pledge.creationTime) && Objects
        .equals(amount, pledge.amount) && Objects.equals(processTime, pledge.processTime);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(creationTime, amount, processTime);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Pledge{" +
        "creationTime=" + creationTime +
        ", amount=" + amount +
        ", processTime=" + processTime +
        '}';
  }
}
