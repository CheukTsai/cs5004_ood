package problem1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a concrete class NonProfit, contains functionality to donate and
 * calculate yearly donations
 */
public class NonProfit{
  private String organization;
  private Set<Donation> donationCollection = new HashSet<>();

  /**
   * Constructs a new NonProfit, with the name of the organization
   * @param organization - String, name of the organization
   */
  public NonProfit(String organization) {
    this.organization = organization;
  }

  /**
   * Adds a Donation to the collection
   * @param donation - Donation, a specific claimed or processed donation
   */
  public void donate(Donation donation){
    this.donationCollection.add(donation);
  }

  /**
   * Returns the total donations for a specific year
   * @param year - Integer, year when donation data need be collected
   * @return Float
   */
  public Float getTotalDonationsForYear(Integer year){
    Float result = 0f;
    for(Donation donation : donationCollection){
      result += donation.countYearlyAmount(year);
    }
    return result;
  }

  /**
   * Returns the collection of the donations
   * @return Set of Donation
   */
  public Set<Donation> getDonationCollection() {
    return donationCollection;
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
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(organization, nonProfit.organization) && Objects
        .equals(donationCollection, nonProfit.donationCollection);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(organization, donationCollection);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "organization='" + organization + '\'' +
        ", donationCollection=" + donationCollection +
        '}';
  }
}
