package problem2;

/**
 * Represents the interface of BagOfWords
 */
public interface BagOfWords {

  /**
   * Creates and returns an empty BagOfWords
   *
   * @return an empty BagOfWords
   */
  static BagOfWords emptyBagOfWords(){
    return new EmptyBagOfWords();
  }

  /**
   * Checks if the BagOfWords is empty. Returns true if the BagOfWords
   * contains no items, false otherwise.
   *
   * @return true if the BagOfWords contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Returns the number of elements in the BagOfWords, duplicates should be
   * counted as separate elements
   *
   * @return the number of elements in the BagOfWords
   */
  Integer size();

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   * @param s the word
   *
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus {@code s}
   */
  BagOfWords add(String s);

  /**
   * Checks if {@code s} is in the BagOfWords
   *
   * @param s a String to be checked
   * @return Returns true if the BagOfWords contains {@code s} and false otherwise.
   */
  Boolean contains(String s);

  /**
   * Removes a word from the BagOfWords
   * @param s the word
   * @return a BagOfWords without the word
   */
  BagOfWords remove(String s);

}
