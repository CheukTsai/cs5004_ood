package problem2;

/**
 * A abstract class Soldier that inherits from its parent class of Piece.
 */
public abstract class Soldier extends Piece{

  private static final Integer MAX_STAMINA = 100;
  private static final Integer MIN_STAMINA = 0;


  private Double stamina;

  /**
   * Constructs a Soldier
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param stamina - Double, stamina of the piece
   */
  public Soldier(Name name, Integer age, Double stamina) {
    super(name, age);
    this.stamina = stamina;
    checkStamina();
  }

  /**
   * Increase stamina
   * @param extraStamina - Double, extra stamina
   */
  public void addStamina(Double extraStamina){
    stamina += extraStamina;
    checkStamina();
  }

  /**
   * Decrease stamina
   * @param extraStamina - Double, extra stamina
   */
  public void removeStamina(Double extraStamina){
    stamina -= extraStamina;
    checkStamina();
  }

  /**
   * Check if stamina is legal
   * @exception - thrown when stamina is illegal
   */
  void checkStamina(){
    if(stamina < MIN_STAMINA || stamina > MAX_STAMINA)
      throw new IllegalArgumentException("Stamina should be between 0 and 100");
  }
}
