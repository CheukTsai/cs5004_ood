package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle testVehicle;
    private Owner expectOwner;
    private Integer expectVIN;
    private String expectLicensePlate;

    @Before
    public void setUp() throws Exception {
      expectOwner = new Owner("Zhuocai", "Li", "4432550275");
      expectVIN = 1234567;
      expectLicensePlate = "7654321";
      testVehicle = new Vehicle(expectVIN, expectLicensePlate, expectOwner);
    }

    @Test
    public void getVIN() {
      assertEquals(expectVIN, testVehicle.getVIN());
    }

    @Test
    public void getLicensePlate() {
      assertEquals(expectLicensePlate, testVehicle.getLicensePlate());
    }

    @Test
    public void getOwner() {
      assertEquals(expectOwner, testVehicle.getOwner());
    }

    @Test
    public void setVIN() {
      Integer newVIN = 8888888;
      testVehicle.setVIN(newVIN);
      assertEquals(newVIN, testVehicle.getVIN());
    }

    @Test
    public void setLicensePlate() {
      String newLicensePlate = "0000000";
      testVehicle.setLicensePlate(newLicensePlate);
      assertEquals(newLicensePlate, testVehicle.getLicensePlate());
    }
}