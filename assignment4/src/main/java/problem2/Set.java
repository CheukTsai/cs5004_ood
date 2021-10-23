package problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a concrete class Set, with functionality to deal with items in the Set,
 * containing items and length of the Set
 */
public class Set {

  private Integer[] items;
  private Integer totalLength;

  /**
   * Constructs a set, with items set to null and totalLength set to 0
   */
  public Set() {
    this.items = null;
    this.totalLength = 0;
  }

  /**
   * Creates and returns an empty Set
   * @return Set
   */
  public Set emptySet(){
    return new Set();
  }

  /**
   * Checks if the Set is empty
   * @return Boolean
   */
  public Boolean isEmpty(){
    return this.totalLength == 0;
  }

  /**
   * Adds the given Integer to the Set iff that the Integer is not already in the Set
   * @param n - Integer, given Integer
   * @return Set
   */
  public Set add(Integer n){
    if(contains(n)) return this;
    Set newSet = new Set();
    Integer[] newItems = new Integer[this.totalLength+1];
    for(int i = 0; i < this.totalLength; i++){
      newItems[i] = this.items[i];
    }
    newItems[this.totalLength] = n;
    newSet.items = newItems;
    newSet.totalLength = this.totalLength + 1;
    return newSet;
  }

  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not
   * in the Set, returns the Set as is
   * @param n - Integer, given Integer
   * @return Set
   */
  public Set remove(Integer n){
    if(!contains(n)) return this;
    Set newSet = new Set();
    Integer[] newItems = new Integer[this.totalLength-1];
    int i = 0;
    for(Integer item : this.items){
      if(item != n){
        newItems[i] = item;
        i++;
      }
    }
    newSet.items = newItems;
    newSet.totalLength = this.totalLength - 1;
    return newSet;
  }

  /**
   * Get the number of items in the Set
   * @return Integer
   */
  public Integer size(){
    return this.totalLength;
  }

  /**
   * Returns true if the given Integer is in the Set, false otherwise
   * @param n - Integer, given Integer
   * @return Boolean
   */
  public Boolean contains(Integer n){
    for(int i = 0; i < this.totalLength; i++){
      if(this.items[i] == n) return true;
    }
    return false;
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
    Set set = (Set) o;
    return totalLength.equals(set.totalLength) && Arrays.equals(items, set.items);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(totalLength);
    result = 31 * result + Arrays.hashCode(items);
    return result;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Set{" +
        "items=" + Arrays.toString(items) +
        ", totalLength=" + totalLength +
        '}';
  }
}
