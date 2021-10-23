package problem1;

/*** Vehicle is an object that has a unique Vehicle
 * Identification Number (VIN), corresponding license plate,
 * and the owner of the vehicle.*/
public class Vehicle {
  private Integer VIN;
  private String licensePlate;
  private Owner owner;
  /**
   * Constructor that creates a new vehicle object with the specified VIN, license plate and owner.
   *
   * @param VIN - VIN of the new Vehicle object.
   * @param licensePlate - license plate of the new Vehicle.
   * @param owner - owner of the new Vehicle.
   */
  public Vehicle(Integer VIN, String licensePlate, Owner owner) {
    this.VIN = VIN;
    this.licensePlate = licensePlate;
    this.owner = owner;
  }
  /**
   * Returns the VIN of the Vehicle.
   *
   * @return the VIN of the Vehicle.
   */
  public Integer getVIN() {
    return this.VIN;
  }

  /**
   * Sets the VIN of the Vehicle.
   *
   * @param VIN - the new VIN of the Vehicle
   */
  public void setVIN(Integer VIN) {
    this.VIN = VIN;
  }

  /**
   * Returns the licensePlate of the Vehicle.
   *
   * @return the licensePlate of the Vehicle.
   */
  public String getLicensePlate() {
    return this.licensePlate;
  }

  /**
   * Sets the licensePlate of the Vehicle.
   *
   * @param licensePlate - the new licensePlate of the Vehicle
   */
  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  /**
   * Returns the owner of the Vehicle.
   *
   * @return the owner of the Vehicle.
   */
  public Owner getOwner() {
    return this.owner;
  }
}
