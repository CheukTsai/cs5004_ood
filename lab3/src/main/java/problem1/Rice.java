package problem1;


/**
 * A concrete class Rice that inherits from its parent class of NonPerishableFood.
 */
public class Rice extends NonPerishableFood{

  /**
   * Constructs a Rice
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Rice(String name, Double currentPricePerUnit, Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }
}
