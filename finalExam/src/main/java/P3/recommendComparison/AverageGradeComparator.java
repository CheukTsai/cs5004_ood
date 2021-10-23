package P3.recommendComparison;

import P3.CourseStatistics;

public class AverageGradeComparator extends RecommendComparator {

  @Override
  public int compare(CourseStatistics o1, CourseStatistics o2) {
    //    if (o1.getAverageGradeOfAllStudents() < o2.getAverageGradeOfAllStudents())
    //      return -1;
    //    else if (o1.getAverageGradeOfAllStudents() > o2.getAverageGradeOfAllStudents())
    //      return 1;
    //    else {
    //      return 0;
    //    }
    return o1.getAverageGradeOfAllStudents().compareTo(o2.getAverageGradeOfAllStudents());
  }
}
