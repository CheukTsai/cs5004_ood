package problem1;


/**
 * A concrete class Fruit that inherits from its parent class of PerishableFood
 */
public class Fruit extends PerishableFood{

  /**
   * Constructs a Fruit
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public Fruit(String name, Double currentPricePerUnit, Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
  }
}


