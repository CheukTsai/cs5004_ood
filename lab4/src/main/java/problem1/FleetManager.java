package problem1;

public class FleetManager {

  public TripReport drive(float distance, Vehicle vehicle){
    float speed = vehicle.getAverageSpeed();
    Integer duration = (int) (distance / speed);
    return new TripReport(vehicle, speed, distance, duration);
  }


  public TripReport drive(Vehicle vehicle, Integer duration){
    float speed = vehicle.getAverageSpeed();
    float distance = duration * speed;
    return new TripReport(vehicle, speed, distance, duration);
  }

  public TripReport drive(Vehicle vehicle, Integer duration, float distance, float speed){
    return new TripReport(vehicle, speed, distance, duration);
  }

  public TripReport drive(Vehicle vehicle, float distance, float speed, Integer duration){
    return new TripReport(vehicle, speed, distance, duration);
  }

  public static void main(String[] args) {
    Vehicle testVehicle1 = new Bus("a", 10f, 50f);
    Vehicle testVehicle2 = new Boat("b", 15f, 40f);
    Vehicle testVehicle3 = new Train("c", 12.5f, 30.5f);

    int duration1 = 600;
    int duration2 = 800;
    int duration3 = 1000;
    float distance1 = 1000f;
    float distance2 = 777f;
    float distance3 = 3000f;

    FleetManager fleetManager = new FleetManager();

    // Tests the first method.
    TripReport tripReport1 = fleetManager.drive(distance1, testVehicle1);
    System.out.println(tripReport1);

    // Tests the second method.
    TripReport tripReport2 = fleetManager.drive(testVehicle1, duration1);
    System.out.println(tripReport2);

    // Tests the third method.
    TripReport tripReport3 = fleetManager.drive(testVehicle2, duration2, distance2,
        testVehicle2.getAverageSpeed());
    System.out.println(tripReport3);

    // Tests the fourth method.
    TripReport tripReport4 =
        fleetManager.drive(testVehicle3, distance3, testVehicle3.getAverageSpeed(), duration3);
    System.out.println(tripReport4);
    
  }
}
