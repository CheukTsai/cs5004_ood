package midtermExam.p1;

public abstract class VeteranEraAntiqueCar extends AntiqueCar{

  private static final Double CONDITION_PRICING_FACTOR_BASIC = 1.0;
  private static final Double CONDITION_PRICING_FACTOR_PERFECT_OR_EXCELLENT = 1.7;

  public VeteranEraAntiqueCar(String uniqueID, Integer age, Integer mileage,
      Condition condition, Double latestAskingPrice) {
    super(uniqueID, age, mileage, condition, latestAskingPrice);
  }

  @Override
  public Double estimatePrice() {
    return super.estimatePrice() * multiplyExtraFactor();
  }

  private Double multiplyExtraFactor() {
    switch (this.condition) {
      case PERFECT:
      case EXCELLENT:
        return CONDITION_PRICING_FACTOR_PERFECT_OR_EXCELLENT;
      default:
        return CONDITION_PRICING_FACTOR_BASIC;
    }
  }
}
