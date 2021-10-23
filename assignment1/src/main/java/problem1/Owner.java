package problem1;

/*** Owner is a simple object that has a unique Vehicle
 * Identification Number (VIN), and corresponding license plate.*/
public class Owner {

  private String firstName;
  private String lastName;
  private String phoneNumber;

  /**
   * Constructor that creates a new Owner object with the specified first name, last name and owner.
   *
   * @param firstName - first name of the new Owner object.
   * @param lastName - last name of the new Owner.
   * @param phoneNumber - owner of the new Vehicle.
   */
  public Owner(String firstName, String lastName, String phoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    if (verifyPhoneNumber(phoneNumber)) {
      this.phoneNumber = phoneNumber;
    } else {
      System.out.println("Your input phone number is invalid");
    }
  }

  /**
   * Verifies if phone number is valid, Returns the boolean value of the phoneNumber verification.
   *
   * @param phoneNumber - phone number.
   * @return the boolean value of the phoneNumber verification.
   */
  public boolean verifyPhoneNumber(String phoneNumber) {
      if(phoneNumber.length() != 10){
          return false;
      }
    for (int i = 0; i < phoneNumber.length(); i++) {
      if (!Character.isDigit(phoneNumber.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the firstName of the Owner.
   *
   * @return the firstName of the Owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the lastName of the Owner.
   *
   * @return the lastName of the Owner.
   */
  public String getLastName() {

    return lastName;
  }

  /**
   * Returns the phoneNumber of the Owner.
   *
   * @return the phoneNumber of the Owner.
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
}
