package midtermExam.p1;

import java.util.Objects;

/**
 * Represents an abstract class ClassicCar, extending its parent class AntiqueCar
 */
public abstract class ClassicCar extends AntiqueCar{
  private Size size;
  private Integer numberOfCylinders;

  private static final Integer CYLINDER_NUMBER_BONUS_LIMIT = 3;
  private static final Double EXTRA_BONUS_BASIC = 0.0;
  private static final Double EXTRA_BONUS = 100000.0;

  /**
   * Constructs a Classic Car, with {@code uniqueID}, {@code age}, {@code mileage},
   * {@code condition}, {@code latestAskingPrice}, {@code size},
   * and {@code numberOfCylinders}
   *
   * @param uniqueID the unique ID of a Classic Car, expressed as a String
   * @param age the age of a Classic Car, expressed as an Integer
   * @param mileage the mileage of a Classic Car, expressed as an Integer
   * @param condition the current condition of a Classic Car, expressed as a Condition
   * @param latestAskingPrice the latest asking price of a Classic Car, expressed as a Double
   * @param size the size of a Classic Car, expressed as a Size
   * @param numberOfCylinders the number of cylinders of a Classic Car, expressed as an Integer
   */
  public ClassicCar(String uniqueID, Integer age, Integer mileage, Condition condition,
      Double latestAskingPrice, Size size, Integer numberOfCylinders) {
    super(uniqueID, age, mileage, condition, latestAskingPrice);
    this.size = size;
    this.numberOfCylinders = numberOfCylinders;
  }

  /**
   * {@inheritDoc}
   * Calculates estimated price of a classic car, with extra bonus added
   *
   * @return the estimated price of a classic car
   */
  @Override
  public Double estimatePrice() {
    return super.estimatePrice() + addExtraBonus();
  }

  /**
   * The size of a Classic Car as LARGE, and with no less than 3 cylinders is
   * increased by an amount of $100,000.
   * (Larger car with strong engine is quite rare at an earlier time, thus would add more extra
   * value to its price)
   *
   * @return extra price bonus after gathering all needed factors, as Double
   */
  private Double addExtraBonus() {
    switch (this.size){
      case LARGE:
        if(this.numberOfCylinders >= CYLINDER_NUMBER_BONUS_LIMIT){
          return EXTRA_BONUS;
        }
        break;
      default:
        break;
    }
    return EXTRA_BONUS_BASIC;
  }

  /**
   * {@inheritDoc}
   * Indicates whether some other object passed as an argument is "equal to" the
   * ClassicCar
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ClassicCar that = (ClassicCar) o;
    return size == that.size && Objects.equals(numberOfCylinders, that.numberOfCylinders);
  }

  /**
   * {@inheritDoc}
   * Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), size, numberOfCylinders);
  }

  /**
   * {@inheritDoc}
   * Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ClassicCar{" +
        "uniqueID='" + uniqueID + '\'' +
        ", age=" + age +
        ", mileage=" + mileage +
        ", condition=" + condition +
        ", latestAskingPrice=" + latestAskingPrice +
        ", size=" + size +
        ", numberOfCylinders=" + numberOfCylinders +
        '}';
  }
}
