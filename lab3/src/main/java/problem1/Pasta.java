package problem1;

/**
 * A concrete class Pasta that inherits from its parent class of NonPerishableFood.
 */
public class Pasta extends NonPerishableFood {

  /**
   * Constructs a Pasta
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Pasta(String name, Double currentPricePerUnit, Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }
}

