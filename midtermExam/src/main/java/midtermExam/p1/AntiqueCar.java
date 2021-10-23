package midtermExam.p1;

import java.util.Objects;

public abstract class AntiqueCar implements AntiqueCarListingSystem{
  protected String uniqueID;
  protected Integer age;
  protected Integer mileage;
  protected Condition condition;
  protected Double latestAskingPrice;

  private static final Double GENERAL_PRICING_FACTOR = 3.2;
  private static final Double CONDITION_PRICING_FACTOR_BASIC = 1.0;
  private static final Double CONDITION_PRICING_FACTOR_PERFECT = 2.15;

  public AntiqueCar(String uniqueID, Integer age, Integer mileage, Condition condition,
      Double latestAskingPrice) {
    this.uniqueID = uniqueID;
    this.age = age;
    this.mileage = mileage;
    this.condition = condition;
    this.latestAskingPrice = latestAskingPrice;
  }

  @Override
  public Double estimatePrice() {
    return latestAskingPrice * GENERAL_PRICING_FACTOR * multiplyExtraFactor();
  }

  private Double multiplyExtraFactor(){
    switch (this.condition){
      case PERFECT:
        return CONDITION_PRICING_FACTOR_PERFECT;
      default:
        return CONDITION_PRICING_FACTOR_BASIC;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AntiqueCar that = (AntiqueCar) o;
    return Objects.equals(uniqueID, that.uniqueID) && Objects
        .equals(age, that.age) && Objects.equals(mileage, that.mileage)
        && condition == that.condition && Objects
        .equals(latestAskingPrice, that.latestAskingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uniqueID, age, mileage, condition, latestAskingPrice);
  }

  @Override
  public String toString() {
    return "AntiqueCar{" +
        "uniqueID='" + uniqueID + '\'' +
        ", age=" + age +
        ", mileage=" + mileage +
        ", condition=" + condition +
        ", latestAskingPrice=" + latestAskingPrice +
        '}';
  }
}
