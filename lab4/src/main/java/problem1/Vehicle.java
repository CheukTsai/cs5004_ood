package problem1;

import java.util.Objects;

public class Vehicle {
  private String ID;
  private Float averageSpeed;
  private Float maxSpeed;

  public Vehicle(String ID, Float averageSpeed, Float maxSpeed) {
    this.ID = ID;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getID() {
    return ID;
  }

  public Float getAverageSpeed() {
    return averageSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(ID, vehicle.ID) && Objects
        .equals(averageSpeed, vehicle.averageSpeed) && Objects
        .equals(maxSpeed, vehicle.maxSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, averageSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "ID='" + ID + '\'' +
        ", averageSpeed=" + averageSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
