package problem2;

/**
 * A concrete class Sniper that inherits from its parent class of Soldier.
 */
public class Sniper extends Soldier{

  /**
   * Constructs a Sniper
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param stamina - Double, stamina of the piece
   */
  public Sniper(Name name, Integer age, Double stamina) {
    super(name, age, stamina);
  }
}
