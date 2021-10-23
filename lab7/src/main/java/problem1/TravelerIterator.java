package problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class that implements from Iterator can represent a Traveler Iterator.
 */
public class TravelerIterator implements Iterator{

  private List<Traveler> travelersWhoDidntTravelOutsideUS;

  /**
   * A constructor that create a new obejct of TravelerIterator
   * @param travelers - List<Traveler>
   */
  public TravelerIterator(List<Traveler> travelers) {
    this.travelersWhoDidntTravelOutsideUS = findNoneOutsideUSTravelers(travelers);
  }

  /**
   * A helper function that return the resultingTravelers
   * @param travelers List<Traveler>
   * @return resultingTravelers
   */
  private List<Traveler> findNoneOutsideUSTravelers(List<Traveler> travelers){
    List<Traveler> resultingTravelers = new ArrayList<>();

    for(Traveler traveler: travelers){
      if(!hasTraveledOutsideUS(traveler))
        resultingTravelers.add(traveler);
    }
    return resultingTravelers;
  }

  /**
   * A helper function that can get the travelers who traveled out side US.
   * @param traveler Traveler
   * @return boolean value
   */
  private boolean hasTraveledOutsideUS(Traveler traveler){
    for(Destination destination: traveler.traveledDestinations()){
      if(!destination.getCountry().equals("US"))
        return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if the iteration has more elements.
   * (In other words, returns {@code true} if {@link #next} would
   * return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return (travelersWhoDidntTravelOutsideUS.size() > 0);
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   */
  @Override
  public Traveler next() {
    if(this.hasNext())
      return this.travelersWhoDidntTravelOutsideUS.remove(0);
    return null;
  }

  /**
   *  Removes from the underlying collection the last element returned
   *  by this iterator (optional operation).
   */
  @Override
  public void remove() {
    throw new RuntimeException("Method is not implemented");
  }

}
