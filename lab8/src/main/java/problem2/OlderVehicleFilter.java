package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that represents an object of OlderVehicleFilter.
 */
public class OlderVehicleFilter {

  private static final Integer FILTER_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * A constructor that creates a new object of OlderVehicleFilter
   * @param vehicles - List
   */
  public OlderVehicleFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * A constructor that creates a new object of OlderVehicleFilter
   * @param vehicle1 - Vehicle
   * @param vehicle2 - Vehicle
   * @param vehicle3 - Vehicle
   */
  public OlderVehicleFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  /**
   * Filter out vehicles that are manufactured after 1999.
   */
  public List<Vehicle> filterOlderVehicles2(){
    List<Vehicle> resultingVehicles = this.vehicles.stream().filter(vehicle ->
        vehicle.isYoungerThanGivenYear(FILTER_YEAR)).collect(Collectors.toList());

    resultingVehicles.forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));
    return resultingVehicles;
  }

}