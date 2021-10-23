package problem1;

/**
 * Represents an Exception, thrown when no such course is found in the catalog
 */
public class CourseNotFoundException extends Exception{

  public CourseNotFoundException() {
    super("No such course is found.");
  }
}
