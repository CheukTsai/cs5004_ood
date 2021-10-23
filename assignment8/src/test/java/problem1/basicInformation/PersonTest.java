package problem1.basicInformation;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phone1;
  private String phone2;
  private String email;
  private String web;
  private Person testPerson;
  private Person testPerson2;
  private Person testPerson3;


  @Before
  public void setUp() throws Exception {
    firstName = "a";
    lastName = "b";
    companyName = "c";
    address = "d";
    city = "e";
    county = "f";
    state = "g";
    zip = "h";
    phone1 = "i";
    phone2 = "j";
    email = "k";
    web = "m";

    testPerson = new Person("a","b","c","d","e","f",
        "g","h","i","j","k","m");
  }

  @Test
  public void getFirstName() {
    assertEquals(testPerson.getFirstName(),"a");
  }

  @Test
  public void getLastName() {
    assertEquals(testPerson.getLastName(),"b");
  }

  @Test
  public void getCompanyName() {
    assertEquals(testPerson.getCompanyName(),"c");
  }

  @Test
  public void getAddress() {
    assertEquals(testPerson.getAddress(),"d");
  }

  @Test
  public void getCity() {
    assertEquals(testPerson.getCity(),"e");
  }

  @Test
  public void getCounty() {
    assertEquals(testPerson.getCounty(),"f");
  }

  @Test
  public void getState() {
    assertEquals(testPerson.getState(),"g");
  }

  @Test
  public void getZip() {
    assertEquals(testPerson.getZip(),"h");
  }

  @Test
  public void getPhone1() {
    assertEquals(testPerson.getPhone1(),"i");
  }

  @Test
  public void getPhone2() {
    assertEquals(testPerson.getPhone2(),"j");
  }

  @Test
  public void getEmail() {
    assertEquals(testPerson.getEmail(),"k");
  }

  @Test
  public void getWeb() {
    assertEquals(testPerson.getWeb(),"m");
  }

  @Test
  public void testEquals1() {
    testPerson2 = new Person("a","b","c","d","e","f",
        "g","h","i","j","k","m");

    assertTrue(testPerson.equals(testPerson));
    assertNotEquals(testPerson,null);
    assertTrue(testPerson.equals(testPerson2));
    assertFalse(testPerson.equals("a"));

    testPerson3 = new Person("x","b","c","d","e","f",
        "g","h","i","j","k","m");

    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","x","c","d","e","f",
        "g","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","x","d","e","f",
        "g","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","x","e","f",
        "g","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","x","f",
        "g","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","x",
        "g","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "x","h","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "g","x","i","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "g","h","x","j","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "g","h","i","x","k","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "g","h","i","j","x","m");
    assertFalse(testPerson.equals(testPerson3));

    testPerson3 = new Person("a","b","c","d","e","f",
        "g","h","i","j","k","x");
    assertFalse(testPerson.equals(testPerson3));

  }

  @Test
  public void testHashCode() {
    int hash = Objects.hash("a","b","c","d","e","f",
        "g","h","i","j","k","m");
    assertEquals(testPerson.hashCode(),hash);
  }

  @Test
  public void testToString() {
    String expectedString = "Person{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", companyName='" + companyName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", county='" + county + '\'' +
        ", state='" + state + '\'' +
        ", zip='" + zip + '\'' +
        ", phone1='" + phone1 + '\'' +
        ", phone2='" + phone2 + '\'' +
        ", email='" + email + '\'' +
        ", web='" + web + '\'' +
        '}';

    assertEquals(testPerson.toString(),expectedString);
  }
}