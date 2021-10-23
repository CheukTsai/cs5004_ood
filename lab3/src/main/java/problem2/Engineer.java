package problem2;

/**
 * A Concrete class Engineer that inherits from its parent class of Civilian.
 */
public class Engineer extends Civilian{

  /**
   * Constructs a new Engineer
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param wealth - Double, wealth of the piece
   */
  public Engineer(Name name, Integer age, Double wealth) {
    super(name, age, wealth);
  }
}
