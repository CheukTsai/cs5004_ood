package problem1;

/**
 * Represents an abstract class Service, including the service's final price and basic information
 * about the customer.
 *
 * @author - Zhuocai Li
 */
public abstract class Service implements ServiceInterface {
  public double finalPrice = 0; // Records the final price during the calculating process.
  protected BasicInformation basicInformation;
  private static final Integer INCREMENT_ONE = 1;
  private static final Integer DIFFERENCE_ONE = 1;
  private static final Integer TENTH = 10;
  private static final double TENTH_DISCOUNT = 0.5;
  private static final double MONTHLY_DISCOUNT = 0.9;


  /**
   * Constructs a new abstract class Service, with basicInformation
   *
   * @param basicInformation - some of the information of customer, expressed as BasicInformation
   */
  public Service(BasicInformation basicInformation) {
    this.basicInformation = basicInformation;
  }

  /**
   * {@inheritDoc}
   * Returns the final price of the service, after adding all the discounts, expressed as a double
   *
   * @return double
   */
  @Override
  public double calculatePrice() {
    this.checkTenthServiceDiscount();
    this.checkMonthlySubscription();

    this.basicInformation.setNumberOfPreviousService(
        this.basicInformation.getNumberOfPreviousService() + INCREMENT_ONE);

    return this.finalPrice;
  }

  /**
   * A helper to check whether this service is the 10th service
   * among all the services the customer has made so far.
   */
  private void checkTenthServiceDiscount(){
    if((this.basicInformation.getNumberOfPreviousService() + DIFFERENCE_ONE) % TENTH == 0){
      this.finalPrice *= TENTH_DISCOUNT;
    }
  }

  /**
   * A helper to check whether the service meets all the requirement
   * to enjoy the monthly subscription discount.
   */
  private void checkMonthlySubscription(){
      if(this.basicInformation.getMonthlySubscription()){
        if((this.basicInformation.getNumberOfPreviousService() + DIFFERENCE_ONE) % TENTH != 0){
          this.finalPrice *= MONTHLY_DISCOUNT;
        }
      }
  }


}
