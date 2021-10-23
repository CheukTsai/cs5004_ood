package problem2;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;

  private Vehicle vehicle;
  private Vehicle vehicle2;

  @Before
  public void setUp() throws Exception {
    make = "a";
    model = "b";
    year = 2021;
    vehicleColor = Color.RED;
    vehicle = new Vehicle(make,model,year,vehicleColor);
    vehicle2 = new Vehicle(make,model,year,vehicleColor);
  }

  @Test
  public void getMake() {
    assertEquals(vehicle.getMake(),make);
  }

  @Test
  public void getModel() {
    assertEquals(vehicle.getModel(),model);
  }

  @Test
  public void getYear() {
    assertEquals(vehicle.getYear(),year);
  }

  @Test
  public void getVehicleColor() {
    assertEquals(vehicle.getVehicleColor(),vehicleColor);
  }

  @Test
  public void testEquals() {
    assertTrue(vehicle.equals(vehicle));
    assertFalse(vehicle.equals(model));
    assertNotEquals(vehicle,null);
    assertTrue(vehicle.equals(vehicle2));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash(make);
    assertEquals(hash,vehicle.hashCode());
  }

  @Test
  public void testToString() {
    String expectedString =  "Vehicle{" +
        "make=’" + make + "’" +
        ", model=’" + model + "'" +
        ", year=" + year +
        ", vehicleColor=" + vehicleColor + "}";
    assertEquals(expectedString,vehicle.toString());
  }

  @Test
  public void testIsYoungerThanGivenYear() {
    assertTrue(vehicle.isYoungerThanGivenYear(1));
    assertFalse(vehicle.isYoungerThanGivenYear(2222));
  }

  @Test
  public void testPrintMakeModelAndYear() {



  }
}