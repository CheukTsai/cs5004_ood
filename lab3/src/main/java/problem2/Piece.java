package problem2;

/**
 * An abstract class Piece that implements from the interface of Piece
 */
public abstract class Piece {

  private static final Integer MAX_AGE = 128;
  private static final Integer MIN_AGE = 0;

  private Name name;
  private Integer age;

  /**
   * Constructs a Piece
   * @param name - Name, name of the piece
   * @param age - Integer, age of the piece
   */
  public Piece(Name name, Integer age) {
    this.name = name;
    this.age = age;
    checkAge();
  }

  /**
   * Check if age is legal
   * @exception - thrown when age is illegal
   */
  private void checkAge(){
    if(age < MIN_AGE || age > MAX_AGE)
      throw new IllegalArgumentException("Age should be between 0 and 128");
  }
}
