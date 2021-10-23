package prob1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a concrete class Agent, with{@code T extends Listing}
 *
 * @param <T> an object Listing
 */
public class Agent<T extends Listing<? extends Property, ? extends Contract>>
    implements IAgent<T> {

  private static final Double ZERO = 0.0;
  private static final Double NON_NEGATIVE = 0.0;
  private static final Double HUNDRED_PERCENTS = 1.0;

  private String name;
  private ArrayList<T> currentListings; // T for limit Listing and main class you can use <? extends XX or super XX>
  private Double commissionRate;
  private Double totalEarnings;

  /**
   * Constructs an Agent, with {@code name}, {@code currentListings}, {@code commissionRate} and
   * {@code totalEarnings}
   *
   * @param name           the name of the agent, as String * @param currentListings the current
   *                       chosen list of the agent, as ArrayList
   * @param commissionRate the commission rate of the agent, as Double
   * @param totalEarnings  the total earnings of the agent, as Double
   */
  public Agent(String name, Double commissionRate, Double totalEarnings) {
    this.name = name;
    this.currentListings = new ArrayList<>();  // instantiate the currentListings
    this.commissionRate = commissionRate;
    this.totalEarnings = totalEarnings;
    this.checkCommissionRate();
  }

  /**
   * Helper, checks if the commission rate is between 0 and 1;
   */
  private void checkCommissionRate() {
    if (this.commissionRate < NON_NEGATIVE || this.commissionRate > HUNDRED_PERCENTS) {
      throw new IllegalArgumentException("Illegal commission rate input");
    }
  }

  /**
   * Adds an (appropriate) listing to the Agent’s current listing collection
   *
   * @param listing the listing to add
   */
  @Override
  public void addListing(T listing) {
    this.currentListings.add(listing);
  }

  /**
   * Is Called when the agent complete a sale/rental of property
   *
   * @param listing the listing to complete
   * @throws ListingNotFoundException thrown when input listing is not found in the currentListing
   */
  @Override
  public void completeListing(T listing) throws ListingNotFoundException {
    if (!currentListings.contains(listing)) {
      throw new ListingNotFoundException("Listing not found.");
    }
    this.totalEarnings += calculateCommission(listing);
    currentListings.remove(listing);
  }


  /**
   * Helper, calculates the commission the agent will get when a deal is made
   *
   * @param listing the listing to calculate commission
   * @return calculated commission
   */
  private double calculateCommission(Listing listing) {
    return this.commissionRate * listing.getContract().askingPrice
        * listing.getContract().getCommissionFactor();
  }

  /**
   * {@inheritDoc} Drops a listing from the Agent’s collection without adjusting their earnings
   *
   * @param listing the listing to drop
   * @throws ListingNotFoundException thrown when input listing is not found in the currentListing
   */
  @Override
  public void dropListing(T listing) throws ListingNotFoundException {
    if (!this.currentListings.contains(listing)) {
      throw new ListingNotFoundException("Listing not found");
    }
    this.currentListings.remove(listing);
  }

  /**
   * {@inheritDoc} Returns the amount of money the Agent would make if they successfully completed
   * all listings in their collection
   *
   * @return the amount of money
   */
  @Override
  public Double getTotalPortfolioValue() {
    Double output = ZERO;
    for (int i = 0; i < currentListings.size(); i++) {
      Listing listing = currentListings.get(i);
      output += calculateCommission(listing);
    }
    return output;
  }


  /**
   * Return currentListings
   *
   * @return currentListings
   */
  public ArrayList<T> getCurrentListings() {
    return currentListings;
  }


  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * Agent
   *
   * @param o - an object to compare
   * @return true if is "equal to", otherwise false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Agent<?> agent = (Agent<?>) o;
    return Objects.equals(name, agent.name) && Objects
        .equals(currentListings, agent.currentListings) && Objects
        .equals(commissionRate, agent.commissionRate) && Objects
        .equals(totalEarnings, agent.totalEarnings);
  }

  /**
   * {@inheritDoc} Returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, currentListings, commissionRate, totalEarnings);
  }

  /**
   * {@inheritDoc} Returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Agent{" +
        "name='" + name + '\'' +
        ", currentListings=" + currentListings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}