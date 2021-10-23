package P3;

import P3.recommendComparison.ALIGNAverageGradeComparator;
import P3.recommendComparison.AverageGradeComparator;
import P3.recommendComparison.NumberOfStudentsComparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseRecommender {

  private static final Integer ALIGN_COURSE_MIN_NUM = 1;
  private static final String COURSE_CODE_CS_5001 = "CS 5001";
  private static final String COURSE_CODE_CS_5002 = "CS 5002";
  private static final String COURSE_CODE_CS_5004 = "CS 5004";
  private static final String COURSE_CODE_CS_5008 = "CS 5008";

  private static final LocalDate DEFAULT_YEAR_TAKEN =
      LocalDate.of(1996, 6, 26);
  private static final Float DEFAULT_GRADE = 0f;

  private List<Student> allStudents;
  private List<Student> ALIGNStudents;
  private Map<String, CourseStatistics> courseStatisticsMap;

  public CourseRecommender(List<Student> allStudents, List<Student> ALIGNStudents,
      Map<String, CourseStatistics> courseStatisticsMap) {
    this.allStudents = allStudents;
    this.ALIGNStudents = ALIGNStudents;
    this.courseStatisticsMap = courseStatisticsMap;
  }

  public CourseRecommender(List<Student> allStudents) {
    this.allStudents = allStudents;
    this.ALIGNStudents = filterOutAlignStudents(allStudents);
    this.courseStatisticsMap = computeCollegeCoursesStatistics(allStudents,
        this.ALIGNStudents);
  }

  /**
   * Recommends courses for specific student: The first recommended course is the first course taken
   * by the most students in the college, that the student hasn't yet taken. (if no such course is
   * found, the first recommended course will be null)
   * <p>
   * The second recommended courses is the course with the highest average grade that the student
   * hasn't already taken. (if no such course is found, the second recommended course will be null)
   * <p>
   * The third recommended courses is the course with the highest average grade among ALIGN
   * students, that the student hasn't already taken. (if no such course is found, the third
   * recommended course will be null)
   *
   * @param student student to be recommended courses
   * @return List of recommended Courses (All recommended courses are with unique Course Code and
   * Course Name, but with same default Year Taken and Grade, since these two data are not generated
   * yet by the student)
   */
  public List<Course> recommendCourses(Student student) {

    List<CourseStatistics> sortedCourseStatisticsList = new ArrayList<>();
    //    for(String courseName : courseStatisticsMap.keySet()) {
    //      sortedCourseStatisticsList.add(courseStatisticsMap.get(courseName));
    //    }
    for (Map.Entry<String, CourseStatistics> entry : courseStatisticsMap.entrySet()) {
      sortedCourseStatisticsList.add(entry.getValue());
    }

    List<Course> recommendCoursesList = new ArrayList<>();

    sortedCourseStatisticsList.sort(new NumberOfStudentsComparator());
    recommendCoursesList.add(getRecommend(sortedCourseStatisticsList, student));

    sortedCourseStatisticsList.sort(new AverageGradeComparator());
    recommendCoursesList.add(getRecommend(sortedCourseStatisticsList, student));

    sortedCourseStatisticsList.sort(new ALIGNAverageGradeComparator());
    recommendCoursesList.add(getRecommend(sortedCourseStatisticsList, student));
    return recommendCoursesList;
  }

  private List<Student> filterOutAlignStudents(List<Student> allStudents) {
    List<Student> outputStudentList = new ArrayList<>();
    for (Student student : allStudents) {
      if (filteredALIGNCourses(student).size() >= ALIGN_COURSE_MIN_NUM) {
        outputStudentList.add(student);
      }
    }
    return outputStudentList;
  }

  private Set<Course> filteredALIGNCourses(Student student) {
    return student.getTakenCourses().stream().filter(x ->
        x.getCourseCode().equals(COURSE_CODE_CS_5001) ||
            x.getCourseCode().equals(COURSE_CODE_CS_5002) ||
            x.getCourseCode().equals(COURSE_CODE_CS_5004) ||
            x.getCourseCode().equals(COURSE_CODE_CS_5008))
        .collect(Collectors.toSet());
  }

  private Map<String, CourseStatistics> computeCollegeCoursesStatistics(
      List<Student> studentList, List<Student> ALIGNStudentList) {
    Map<String, String> courseMap = new HashMap<>();
    Map<String, CourseStatistics> output = new HashMap<>();
    for (Student student : studentList) {
      for (Course course : student.getTakenCourses()) {
        courseMap.put(course.getCourseName(), course.getCourseCode());
      }
    }
    //    for(String courseName : courseMap.keySet()) {
    //      CourseStatistics courseStatistics = new CourseStatistics(courseName,
    //          courseMap.get(courseName), studentList);
    //      output.put(courseName, courseStatistics);
    //    }
    for (Map.Entry<String, String> entry : courseMap.entrySet()) {
      output.put(entry.getKey(),
          new CourseStatistics(entry.getKey(), entry.getValue(), studentList, ALIGNStudentList));
    }
    return output;
  }

  private Course getRecommend(List<CourseStatistics> courseStatisticsList, Student student) {
    for (CourseStatistics courseStatistics : courseStatisticsList) {
      for (Course course : student.getTakenCourses()) {
        if (!courseStatistics.getCourseCode().equals(course.getCourseCode())) {
          return new Course(courseStatistics.getCourseName(),
              courseStatistics.getCourseCode(), DEFAULT_YEAR_TAKEN, DEFAULT_GRADE);
        }
      }
    }
    return null;
  }
}