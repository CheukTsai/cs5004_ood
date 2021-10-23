package P2;

import java.util.Comparator;

public class CurrentAppSizeComparator<T> implements Comparator<MobileApp> {

  /**
   * Compares the current size of 2 MobileApps (Can be simplify as Float.compareTo(), original code
   * is presented)
   *
   * @param o1 1st MobileApp
   * @param o2 2nd MobileApp
   * @return -1 if 1st MobileApp's current size is less; 1 if 1st MobileApp's current size is
   * greater; 0 if their current size is equal
   * @throws NullPointerException if an argument is null and this comparator does not permit null
   *                              arguments
   * @throws ClassCastException   if the arguments' types prevent them from being compared by this
   *                              comparator.
   */
  @Override
  public int compare(MobileApp o1, MobileApp o2) {
    //    if (o1.getCurrentSize() < o2.getCurrentSize()) return -1;
    //    else if (o1.getCurrentSize() > o2.getCurrentSize()) return 1;
    //    else return 0;
    return o1.getCurrentSize().compareTo(o2.getCurrentSize());
  }
}
