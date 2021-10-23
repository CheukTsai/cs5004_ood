package P3.recommendComparison;

import P3.CourseStatistics;

public class NumberOfStudentsComparator extends RecommendComparator {

  @Override
  public int compare(CourseStatistics o1, CourseStatistics o2) {
    //    if (o1.getNumberOfAllStudents() < o2.getNumberOfAllStudents())
    //      return -1;
    //    else if (o1.getNumberOfAllStudents() > o2.getNumberOfAllStudents())
    //      return 1;
    //    else {
    //      return 0;
    //    }
    return o1.getNumberOfAllStudents().compareTo(o2.getNumberOfAllStudents());
  }
}