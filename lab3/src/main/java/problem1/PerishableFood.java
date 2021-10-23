package problem1;

import java.time.LocalDate;
import java.time.Period;

/**
 * A abstract class PerishableFood that inherits from its parent class of AbstractFoodItem.
 */
public abstract class PerishableFood extends Food {

  private static final LocalDate ORDER_DATE_EDGE = LocalDate.of(2021,5,15);
  private static final LocalDate EXPIRATION_DATE_EDGE =
      LocalDate.of(2021,12,31);
  private static LocalDate today = LocalDate.now();
  private Period orderDate;
  private Period expirationDate;

  /**
   * Constructs a PerishableFood
   * @param name - String, name of food
   * @param currentPricePerUnit - Double, current price per unit
   * @param currentAvailableQuantity - Integer, current available quantity
   */
  public PerishableFood(String name, Double currentPricePerUnit,
      Integer currentAvailableQuantity) {
    super(name, currentPricePerUnit, currentAvailableQuantity);
    this.orderDate = ORDER_DATE_EDGE.until(today);
    this.expirationDate = today.until(EXPIRATION_DATE_EDGE);
    MAX_QUANTITY = 100;
  }
}
