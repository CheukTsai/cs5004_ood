package problem1;

/** Exception class, thrown when too many employees are needed. */
public class OutNumberedLicensedEmployeeException extends Exception{

  public OutNumberedLicensedEmployeeException() {
    super("Too many licensed employees are required for this service");
  }
}
