package prob1;

/**
 * Represents the Interface of Agent
 * @param <T> Object for an agent to take specific actions on
 */
public interface IAgent<T> {

  /**
   * Adds an (appropriate) listing to the Agent’s current listing collection
   *
   * @param listing the listing to add
   */
  void addListing(T listing);

  /**
   * Is Called when the agent complete a sale/rental of property
   *
   * @param listing the listing to complete
   * @throws ListingNotFoundException thrown when input listing is not found in the currentListing
   */
  void completeListing(T listing) throws ListingNotFoundException;

  /**
   * {@inheritDoc} Drops a listing from the Agent’s collection without adjusting their earnings
   *
   * @param listing the listing to drop
   * @throws ListingNotFoundException thrown when input listing is not found in the currentListing
   */
  void dropListing(T listing) throws ListingNotFoundException;

  /**
   * {@inheritDoc} Returns the amount of money the Agent would make if they successfully completed
   * all listings in their collection
   *
   * @return the amount of money
   */
  Double getTotalPortfolioValue();
}
