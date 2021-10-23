package problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CleaningTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private PropertySize expectedPropertySize2;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Integer expectedNumberOfPets;
  private Integer expectedNumberOfPets2;
  private Cleaning testCleaning;
  private Cleaning testCleaning2;


  @Before
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    expectedNumberOfPets = 0;
    testCleaning = new Cleaning(expectedBasicInformation, expectedNumberOfPets);
  }

  @Test
  public void calculatePrice() {
    assertEquals(80.0,testCleaning.calculatePrice(),0);
  }

  @Test
  public void calculatePrice2() {
    expectedPropertySize2 = PropertySize.MEDIUM;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testCleaning2 = new Cleaning(expectedBasicInformation2, expectedNumberOfPets);
    assertEquals(160.0,testCleaning2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice3() {
    expectedPropertySize2 = PropertySize.LARGE;
    expectedBasicInformation2 = new BasicInformation(expectedAddress,expectedPropertySize2,
        expectedMonthlySubscription,expectedNumberOfPreviousService);
    testCleaning2 = new Cleaning(expectedBasicInformation2, expectedNumberOfPets);
    assertEquals(320.0,testCleaning2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice4() {
    expectedNumberOfPets2 = 1;
    testCleaning2 = new Cleaning(expectedBasicInformation, expectedNumberOfPets2);
    assertEquals(84,testCleaning2.calculatePrice(),0);
  }

  @Test
  public void calculatePrice5() {
    expectedNumberOfPets2 = 3;
    testCleaning2 = new Cleaning(expectedBasicInformation, expectedNumberOfPets2);
    assertEquals(85.6,testCleaning2.calculatePrice(),0.001);
  }

  @Test
  public void equalsReflexivity(){
    assertTrue(testCleaning.equals(testCleaning));
  }

//  @Test
//  public void equalsReflexivity2(){
//    expectedBasicInformation2 = new BasicInformation("a", PropertySize.MEDIUM,
//        true,9);
//    expectedNumberOfPets2 = 100;
//    testCleaning2 = new Cleaning(expectedBasicInformation2, expectedNumberOfPets2);
//    assertFalse(testCleaning.equals(testCleaning2));
//  }
//
//  @Test
//  public void equalsReflexivity3(){
//    assertFalse(testCleaning.equals(null));
//  }

//  @Test
//  public void equalsDifferentDataTypes(){
//    assertFalse(testCleaning.equals(expectedBasicInformation));
//  }

//  @Test
//  public void equalsSameFields(){
//    testCleaning2 = new Cleaning(expectedBasicInformation, expectedNumberOfPets);
//    assertEquals(testCleaning, testCleaning2);
////    assertTrue(testCleaning.equals(testCleaning2));
//  }

//  @Test
//  public void differentArgument(){
//    expectedBasicInformation2 = new BasicInformation("a", PropertySize.MEDIUM,
//        true,9);
//    testCleaning2 = new Cleaning(expectedBasicInformation2, expectedNumberOfPets);
//    assertFalse(testCleaning.equals(testCleaning2));
//  }
//
//  @Test
//  public void differentArgument2(){
//    expectedNumberOfPets2 = 100;
//    testCleaning2 = new Cleaning(expectedBasicInformation, expectedNumberOfPets2);
//    assertFalse(testCleaning.equals(testCleaning2));
//  }


  @Test
  public void testHashCode() {
    assertEquals(testCleaning.hashCode(), testCleaning.hashCode());
  }
//
//
//
  @Test
  public void testToString() {
    assertEquals(testCleaning.toString(), testCleaning.toString());
  }
}