package problem1;

import java.util.Objects;

public class TripReport {
  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Float getSpeed() {
    return speed;
  }

  public Float getDistance() {
    return distance;
  }

  public Integer getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripReport that = (TripReport) o;
    return Objects.equals(vehicle, that.vehicle) && Objects
        .equals(speed, that.speed) && Objects.equals(distance, that.distance)
        && Objects.equals(duration, that.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speed, distance, duration);
  }

  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + vehicle +
        ", speed=" + speed +
        ", distance=" + distance +
        ", duration=" + duration +
        '}';
  }
}
