package problem2;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OlderVehicleFilterTest {
  private static final Integer FILTER_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();

  private OlderVehicleFilter olderVehicleFilter;
  private OlderVehicleFilter olderVehicleFilter2;

  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;

  private String make2;
  private String model2;
  private Integer year2;
  private Color vehicleColor2;

  private String make3;
  private String model3;
  private Integer year3;
  private Color vehicleColor3;

  private Vehicle vehicle;
  private Vehicle vehicle2;
  private Vehicle vehicle3;

  @Before
  public void setUp() throws Exception {
    make = "a";
    model = "b";
    year = 2021;
    vehicleColor = Color.RED;

    make2 = "a1";
    model2 = "b1";
    year2 = 2022;
    vehicleColor2 = Color.YELLOW;

    make3 = "a3";
    model3 = "b3";
    year3 = 1990;
    vehicleColor3 = Color.BLUE;

    vehicle = new Vehicle(make,model,year,vehicleColor);
    vehicle2 = new Vehicle(make2,model2,year2,vehicleColor2);
    vehicle3 = new Vehicle(make3,model3,year3,vehicleColor3);

    vehicles.add(vehicle);
    vehicles.add(vehicle2);
    vehicles.add(vehicle3);

    olderVehicleFilter = new OlderVehicleFilter(vehicles);
    olderVehicleFilter2 = new OlderVehicleFilter(vehicle,vehicle2,vehicle3);
  }

  @Test
  public void filterOlderVehicles2() {
    assertTrue(olderVehicleFilter.filterOlderVehicles2().contains(vehicle));
  }
}