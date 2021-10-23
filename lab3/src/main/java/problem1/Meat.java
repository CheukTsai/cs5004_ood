package problem1;

/**
 * A concrete class Meat that inherits from its parent class of PerishableFood
 */
public class Meat extends PerishableFood{

  /**
   * Constructs a Meat
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Meat(String name, Double currentPricePerUnit, Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }
}
