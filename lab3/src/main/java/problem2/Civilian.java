package problem2;

/**
 * An abstract class Civilian that inherits from its parent class of Piece.
 */
public abstract class Civilian extends Piece{

  private Double wealth;

  /**
   * Constructs a new Civilian
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   * @param wealth - Double, wealth of the piece
   */
  public Civilian(Name name, Integer age, Double wealth) {
    super(name, age);
    this.wealth = wealth;
    checkWealth();
  }

  /**
   * Increase wealth
   * @param money - Double, extra money
   */
  void addWealth(Double money){
    wealth += money;
    checkWealth();
  }

  /**
   * Decrease wealth
   * @param money - Double, extra money
   */
  void removeWealth(Double money){
    wealth -= money;
    checkWealth();
  }

  /**
   * Check if wealth legal
   * @exception - thrown when wealth is illegal
   */
  void checkWealth(){
    if(wealth <= 0) throw new IllegalArgumentException("Wealth should be positive");
  }

}
