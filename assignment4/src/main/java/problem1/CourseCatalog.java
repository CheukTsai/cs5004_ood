package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a concrete class CourseCatalog, with functionality to deal with courses, containing
 * courses information and its size
 */
public class CourseCatalog {

  private Course[] courses;
  private int totalNum;

  /** Constructs CourseCatalog, with courses set to null and totalNum set to 0 */
  public CourseCatalog() {
    this.courses = null;
    this.totalNum = 0;
  }

  /**
   * Adds a Course to the end of the CourseCatalog
   *
   * @param newCourse - Course, course to be added
   */
  public void append(Course newCourse) {
    Course[] newCourses = new Course[totalNum + 1];
    if(this.totalNum > 0){
    System.arraycopy(this.courses, 0, newCourses, 0, this.totalNum);}
    newCourses[totalNum] = newCourse;
    this.courses = newCourses;
    this.totalNum++;
  }

  /**
   * Removes a Course from the CourseCatalog
   *
   * @param course - Course, course to be removed
   * @throws CourseNotFoundException - thrown when no such course is found in the catalog
   */
  public void remove(Course course) throws CourseNotFoundException {
    checkExistingClass(course);
    Course[] newCourses = new Course[this.totalNum - 1];
    int i = 0;
    for (Course existingCourse : this.courses) {
      if (!existingCourse.equals(course)) {
        newCourses[i] = existingCourse;
        i++;
      }
    }
    this.courses = newCourses;
    this.totalNum--;
  }

  /**
   * Checks if a course shows up in the catalog
   *
   * @param course - Course, course to be checked
   * @return boolean
   */
  public boolean contains(Course course) {
    if (this.totalNum > 0) {
      for (Course existingCourse : this.courses) {
        if (existingCourse.equals(course)) return true;
      }
    }
    return false;
  }

  /**
   * Returns the index of a specified course in the catalog
   *
   * @param course - Course, course whose index to be found
   * @return int
   */
  public int indexOf(Course course) {
    for (int i = 0; i < this.totalNum; i++) {
      if (this.courses[i].equals(course)) return i;
    }
    return -1;
  }

  /**
   * Returns the number of the courses in the catalog
   *
   * @return int
   */
  public int count() {
    return this.totalNum;
  }

  /**
   * Returns the Course at the given index in the catalog
   *
   * @param i - int, the index of the Course
   * @return Course
   * @throws InvalidIndexException - thrown when the index doesn't exist
   */
  public Course get(int i) throws InvalidIndexException {
    checkIndex(i);
    return this.courses[i];
  }

  /**
   * Checks if the catalog is empty
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return this.totalNum == 0;
  }

  /**
   * Helper, checks if a course exists in the catalog
   *
   * @param course - Course, course to be checked
   * @throws CourseNotFoundException - thrown when no such course is found in the catalog
   */
  private void checkExistingClass(Course course) throws CourseNotFoundException {
    if (!this.contains(course)) throw new CourseNotFoundException();
  }

  /**
   * Helper, checks if an index exists
   *
   * @param i - int, index of a Course
   * @throws InvalidIndexException - thrown when the index doesn't exist
   */
  private void checkIndex(int i) throws InvalidIndexException {
    if (i < 0 || i >= this.totalNum) throw new InvalidIndexException();
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return totalNum == that.totalNum && Arrays.equals(courses, that.courses);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(totalNum);
    result = 31 * result + Arrays.hashCode(courses);
    return result;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CourseCatalog{"
        + "courses="
        + Arrays.toString(courses)
        + ", totalNum="
        + totalNum
        + '}';
  }
}
