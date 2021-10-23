package problem2;

/**
 * A Concrete class Farmer that inherits from its parent class of Civilian.
 */
public class Farmer extends Civilian{

  /**
   * Constructs a new Farmer
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param wealth - Double, wealth of the piece
   */
  public Farmer(Name name, Integer age, Double wealth) {
    super(name, age, wealth);
  }
}
