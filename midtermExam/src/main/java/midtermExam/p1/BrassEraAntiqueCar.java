package midtermExam.p1;

public abstract class BrassEraAntiqueCar extends AntiqueCar{

  private static final Double CONDITION_EXTRA_BONUS_BASIC = 0.0;
  private static final Double CONDITION_EXTRA_BONUS = 125000.0;

  public BrassEraAntiqueCar(String uniqueID, Integer age, Integer mileage,
      Condition condition, Double latestAskingPrice) {
    super(uniqueID, age, mileage, condition, latestAskingPrice);
  }

  @Override
  public Double estimatePrice() {
    return super.estimatePrice() + addExtraBonus();
  }

  private Double addExtraBonus() {
    switch (this.condition) {
      case PERFECT:
      case EXCELLENT:
      case FINE:
        return CONDITION_EXTRA_BONUS;
      default:
        return CONDITION_EXTRA_BONUS_BASIC;
    }
  }
}
