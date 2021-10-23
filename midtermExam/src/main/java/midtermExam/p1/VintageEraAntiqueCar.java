package midtermExam.p1;

public abstract class VintageEraAntiqueCar extends AntiqueCar{

  private static final Integer MILEAGE_BONUS_LIMIT = 300000;
  private static final Double MILEAGE_EXTRA_BONUS_BASIC = 0.0;
  private static final Double MILEAGE_EXTRA_BONUS_LESS_THAN_300000 = 50000.0;

  public VintageEraAntiqueCar(String uniqueID, Integer age, Integer mileage,
      Condition condition, Double latestAskingPrice) {
    super(uniqueID, age, mileage, condition, latestAskingPrice);
  }

  @Override
  public Double estimatePrice() {
    return super.estimatePrice() + addExtraMileageValue();
  }

  private Double addExtraMileageValue(){
    if(this.mileage < MILEAGE_BONUS_LIMIT){
      return MILEAGE_EXTRA_BONUS_LESS_THAN_300000;
    }
    return MILEAGE_EXTRA_BONUS_BASIC;
  }
}
