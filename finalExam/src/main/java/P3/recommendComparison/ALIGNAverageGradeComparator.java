package P3.recommendComparison;

import P3.CourseStatistics;

public class ALIGNAverageGradeComparator extends RecommendComparator {

  @Override
  public int compare(CourseStatistics o1, CourseStatistics o2) {
    //    if (o1.getAverageGradeOfALIGNStudents() < o2.getAverageGradeOfALIGNStudents())
    //      return -1;
    //    else if (o1.getAverageGradeOfALIGNStudents() > o2.getAverageGradeOfALIGNStudents())
    //      return 1;
    //    else {
    //      return 0;
    //    }
    return o1.getAverageGradeOfALIGNStudents().compareTo(o2.getAverageGradeOfALIGNStudents());
  }
}
