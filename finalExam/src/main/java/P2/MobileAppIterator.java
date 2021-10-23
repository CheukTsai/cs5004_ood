package P2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a MobileApps Iterator
 */
public class MobileAppIterator implements Iterator<MobileApp> {

  private static final int HEAD_INDEX = 0;
  private static final LocalDate RELEASE_DATE = LocalDate.of(2017, 1, 1);
  private static final MobileAppCategory CAT_EDUCATION_APP = MobileAppCategory.EDUCATIONAL_APP;
  private static final MobileAppCategory CAT_PRODUCTIVITY_APP = MobileAppCategory.PRODUCTIVITY_APP;
  private static final String PERMISSION_PHOTOS = "PHOTOS";
  private static final String PERMISSION_MESSAGES = "MESSAGES";
  private static final String PERMISSION_LOCATION = "LOCATION";
  private List<MobileApp> mobileAppList;

  /**
   * Constructs a MobileAppIterator.
   *
   * @param mobileAppList List of MobileApps that needs to iterate.
   */
  public MobileAppIterator(List<MobileApp> mobileAppList) {
    this.mobileAppList = mobileAppList;
  }

  /**
   * Returns true if the iteration has more elements, otherwise false.
   *
   * @return true if the iteration has more elements, otherwise false.
   */
  @Override
  public boolean hasNext() {
    return mobileAppList.size() > 0;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException – if the iteration has no more elements
   */
  @Override
  public MobileApp next() throws NoSuchElementException {
    return mobileAppList.remove(HEAD_INDEX);
  }

  /**
   * Returns all those mobile apps that were originally released after the date 1/1/2017, that
   * belong into either EDUCATIONAL_APP or PRODUCTIVITY_APP category, and that are not requesting
   * permissions to access a user’s photos, messages and location. For the purposes of verifying
   * that these three resources are not being requested, you can search for Strings "PHOTOS",
   * "MESSAGES" and "LOCATION".
   *
   * @return List of MobileApps meeting all requirements
   */
  public List<MobileApp> collectNeededMobileApps() {
    List<MobileApp> outputMobileAppList = new ArrayList<>();
    for (MobileApp mobileApp : this.mobileAppList) {
      if (mobileApp.getAppCategory().equals(CAT_EDUCATION_APP) ||
          mobileApp.getAppCategory().equals(CAT_PRODUCTIVITY_APP)) {
        if (mobileApp.getDateOfOriginalRelease().isAfter(RELEASE_DATE)) {
          if (!mobileApp.getRequestedPermissions().contains(PERMISSION_PHOTOS) &&
              !mobileApp.getRequestedPermissions().contains(PERMISSION_MESSAGES) &&
              !mobileApp.getRequestedPermissions().contains(PERMISSION_LOCATION)) {
            outputMobileAppList.add(mobileApp);
          }
        }
      }
    }
    return outputMobileAppList;
  }
}
