package midtermExam.p1;

public class FordMotorT extends BrassEraAntiqueCar{

  private static final Integer MILEAGE_BONUS_LIMIT = 500000;
  private static final Double EXTRA_BONUS_BASIC = 0.0;
  private static final Double EXTRA_BONUS= 225000.0;

  public FordMotorT(String uniqueID, Integer age, Integer mileage, Condition condition,
      Double latestAskingPrice) {
    super(uniqueID, age, mileage, condition, latestAskingPrice);
  }

  @Override
  public Double estimatePrice() {
    return super.estimatePrice() + addExtraFactor();
  }

  private Double addExtraFactor() {
    switch (this.condition) {
      case EXCELLENT:
        if(this.mileage < MILEAGE_BONUS_LIMIT){
          return EXTRA_BONUS;
        }
        break;
      default:
        break;
    }
    return EXTRA_BONUS_BASIC;
  }
}
