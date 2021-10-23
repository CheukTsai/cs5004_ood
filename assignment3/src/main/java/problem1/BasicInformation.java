package problem1;

import java.util.Objects;

/**
 * Represents an concrete class BasicInformation, including the customer's address, property size,
 * number of previous services the customer has ordered, and whether the ordering service is
 * monthly subscribed.
 *
 * @author - Zhuocai Li
 */
public class BasicInformation {
  private String address;
  private PropertySize propertySize;
  private Boolean monthlySubscription;
  private Integer numberOfPreviousService;

  /**
   * Constructs a new BasicInformation, with address, propertySize,
   * monthlySubscription, and numberOfPreviousService.
   *
   * @param address - the address of the customer's property, expressed as a String
   * @param propertySize - the size of the property, expressed as an PropertySize (Enum)
   * @param monthlySubscription - whether the service is monthly subscribed, expressed as a boolean
   * @param numberOfPreviousService - the number of previous services, expressed as an Integer
   */
  public BasicInformation(String address, PropertySize propertySize, Boolean monthlySubscription,
      Integer numberOfPreviousService) {
    this.address = address;
    this.propertySize = propertySize;
    this.monthlySubscription = monthlySubscription;
    this.numberOfPreviousService = numberOfPreviousService;
  }

  /**
   * Returns the size of the property, expressed as an PropertySize
   * @return PropertySize
   */
  public PropertySize getPropertySize() {
      return propertySize;
  }

  /**
   * Returns whether the service is monthly subscribed, expressed as a boolean
   * @return boolean
   */
  public Boolean getMonthlySubscription() {
    return monthlySubscription;
  }

  /**
   * Returns the number of previous services, expressed as an Integer
   * @return Integer
   */
  public Integer getNumberOfPreviousService() {
    return numberOfPreviousService;
  }

  /**
   * Sets the number of previous services
   * @param numberOfPreviousService - the number of previous services
   */
  public void setNumberOfPreviousService(Integer numberOfPreviousService) {
    this.numberOfPreviousService = numberOfPreviousService;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicInformation that = (BasicInformation) o;
    return Objects.equals(address, that.address) && propertySize == that.propertySize
        && Objects.equals(monthlySubscription, that.monthlySubscription)
        && Objects.equals(numberOfPreviousService, that.numberOfPreviousService);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, propertySize, monthlySubscription, numberOfPreviousService);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return "BasicInformation{" +
        "address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", monthlySubscription=" + monthlySubscription +
        ", numberOfPreviousService=" + numberOfPreviousService +
        '}';
  }
}


