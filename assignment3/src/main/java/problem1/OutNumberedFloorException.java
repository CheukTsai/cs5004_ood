package problem1;

/** Exception class, thrown when there are too many floors. */
public class OutNumberedFloorException extends Exception{

  public OutNumberedFloorException() {
    super("Cannot provide window cleaning service for a house containing over 3 floors");
  }
}
