package problem3;

/**
 * A interface that is defined ImmutableListOfStrings.
 */
public interface ImmutableListOfStrings {
  Boolean isEmpty();
  Integer size();
  Boolean contains(String item);
  Boolean containsAll(ImmutableListOfStrings items);
  ImmutableListOfStrings filterLargerThan(Integer strLen);
  Boolean hasDuplicates();
  ImmutableListOfStrings removeDuplicates();
  ImmutableListOfStrings add(String item);
}
