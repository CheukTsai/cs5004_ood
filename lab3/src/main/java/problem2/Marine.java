package problem2;

/**
 * A concrete class SMarine that inherits from its parent class of Soldier.
 */
public class Marine extends Soldier{

  /**
   * Constructs a Marine
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param stamina - Double, stamina of the piece
   */
  public Marine(Name name, Integer age, Double stamina) {
    super(name, age, stamina);
  }
}
