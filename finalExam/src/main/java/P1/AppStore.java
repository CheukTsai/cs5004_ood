package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
Class AppStore contains information about two different categories of apps - approved apps,
and apps currently under review, for approval and addition to the app store. Approved apps
are stored into a map, where the app represents the key, and the number of downloads,
represented as an Integer is the corresponding value.
 */
public class AppStore {

  private Map<MobileApp, Integer> approvedApps;
  private List<MobileApp> appsUnderReview;

  public AppStore(Map<MobileApp, Integer> approvedApps, List<MobileApp> appsUnderReview) {
    this.approvedApps = approvedApps;
    this.appsUnderReview = appsUnderReview;
  }

  public Map<MobileApp, Integer> getApprovedApps() {
    return approvedApps;
  }

  public List<MobileApp> getAppsUnderReview() {
    return appsUnderReview;
  }

  /**
   * Filters wanted MobileApps, if the category of the mobile app is the same as requested category
   * and the original release date is after the requested date
   *
   * @param requestedCategory specific category of the mobile app
   * @param requestedDate     a specific date, as a LocalDate
   * @return List of filtered MobileApp
   */

  public List<MobileApp> mysteryMethod(MobileAppCategory requestedCategory,
      LocalDate requestedDate) {
    return this.approvedApps.keySet().stream()
        .filter(x -> x.getAppCategory().equals(requestedCategory))
        .filter(y -> y.getDateOfOriginalRelease().isAfter(requestedDate))
        .collect(Collectors.toList());
  }

  /**
   * Returns a list of all mobile apps currently under review for inclusion into the app store, that
   * are requesting at most the number of permissions defined by the input argument Integer
   * maxNumPermissions, and that are not requesting any of the permissions provided as input
   * arguments, String permission1 or permission2.
   *
   * @param maxNumPermissions at most the number of permissions
   * @param permission1       1st requested permission
   * @param permission2       2nd requested permission
   * @return a list of all mobile apps currently under review meeting all requirements
   */

  public List<MobileApp> filterByRequestedPermissions(Integer maxNumPermissions, String permission1,
      String permission2) {
    //YOUR CODE HERE
    return this.appsUnderReview.stream().filter(x ->
        x.getRequestedPermissions().size() <= maxNumPermissions &&
            !x.getRequestedPermissions().contains(permission1) &&
            !x.getRequestedPermissions().contains(permission2)).collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AppStore)) {
      return false;
    }
    AppStore appStore = (AppStore) o;
    return Objects.equals(getApprovedApps(), appStore.getApprovedApps()) &&
        Objects.equals(getAppsUnderReview(), appStore.getAppsUnderReview());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getApprovedApps(), getAppsUnderReview());
  }

  @Override
  public String toString() {
    return "AppStore{" +
        "approvedApps=" + approvedApps +
        ", appsUnderReview=" + appsUnderReview +
        '}';
  }
}
