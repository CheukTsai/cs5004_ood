package P3;

import java.util.List;

public class CourseStatistics {

  private String courseName;
  private String courseCode;
  private List<Student> studentList;
  private List<Student> ALIGNStudentList;
  private Integer numberOfAllStudents;
  private Integer numberOfALIGNStudents;
  private Float averageGradeOfAllStudents;
  private Float averageGradeOfALIGNStudents;

  public CourseStatistics(String courseName, String courseCode, List<Student> studentList,
      List<Student> ALIGNStudentList) {
    this.courseName = courseName;
    this.courseCode = courseCode;
    this.studentList = studentList;
    this.ALIGNStudentList = ALIGNStudentList;
    this.allStudentsFieldHelper();
    this.ALIGNStudentsFieldHelper();
  }

  private void allStudentsFieldHelper() {
    int tempNumberOfAllStudents = 0;
    float totalGrade = 0f;

    for (Student student : this.studentList) {
      for (Course course : student.getTakenCourses()) {
        if (course.getCourseName().equals(this.courseName)) {
          tempNumberOfAllStudents++;
          totalGrade += course.getGrade();
        }
      }
    }

    this.numberOfAllStudents = tempNumberOfAllStudents;
    this.averageGradeOfAllStudents = tempNumberOfAllStudents == 0 ?
        0f : (totalGrade / tempNumberOfAllStudents);
  }

  private void ALIGNStudentsFieldHelper() {
    int tempNumberOfALIGNStudents = 0;
    float totalALIGNGrade = 0f;

    for (Student student : this.ALIGNStudentList) {
      for (Course course : student.getTakenCourses()) {
        if (course.getCourseName().equals(this.courseName)) {
          tempNumberOfALIGNStudents++;
          totalALIGNGrade += course.getGrade();
        }
      }
    }

    this.numberOfALIGNStudents = tempNumberOfALIGNStudents;
    this.averageGradeOfALIGNStudents = tempNumberOfALIGNStudents == 0 ?
        0f : (totalALIGNGrade / tempNumberOfALIGNStudents);
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public Integer getNumberOfAllStudents() {
    return numberOfAllStudents;
  }

  public Integer getNumberOfALIGNStudents() {
    return numberOfALIGNStudents;
  }

  public Float getAverageGradeOfAllStudents() {
    return averageGradeOfAllStudents;
  }

  public Float getAverageGradeOfALIGNStudents() {
    return averageGradeOfALIGNStudents;
  }
}
