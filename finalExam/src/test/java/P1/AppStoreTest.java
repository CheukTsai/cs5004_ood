package P1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class AppStoreTest {

  private String appName;
  private MobileAppCategory appCategory1;
  private MobileAppCategory appCategory2;
  private Float currentVersion;
  private Float currentSize;
  private List<Name> developers;
  private List<String> requestedPermissions;
  private LocalDate dateOfOriginalRelease1;
  private LocalDate dateOfOriginalRelease2;
  private LocalDate requestedDate;
  private LocalDate dateOfLatestUpdate;
  private MobileApp mobileApp1;
  private MobileApp mobileApp2;
  private MobileApp mobileApp3;
  private MobileApp mobileApp4;
  private Map<MobileApp, Integer> mobileAppIntegerMap;
  private List<MobileApp> appsUnderReview;
  private AppStore appStore;

  @Before
  public void setUp() throws Exception {
    appName = "a";
    appCategory1 = MobileAppCategory.EDUCATIONAL_APP;
    appCategory2 = MobileAppCategory.GAME_APP;
    currentVersion = 1f;
    currentSize = 2f;
    developers = new ArrayList<>();
    developers.add(new Name("Zhuocai", "Tsai", "Li"));
    requestedPermissions = new ArrayList<>();
    requestedPermissions.add("go");
    dateOfOriginalRelease1 = LocalDate.of(2021,1,1);
    dateOfOriginalRelease2 = LocalDate.of(1800,1,1);
    requestedDate = LocalDate.of(1990,1,1);
    dateOfLatestUpdate = LocalDate.of(2021,12,31);
    mobileApp1 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);
    mobileApp2 = new MobileApp(appName,appCategory2,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);
    mobileApp3 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease2,dateOfLatestUpdate);
    mobileAppIntegerMap = new HashMap<>();
    mobileAppIntegerMap.put(mobileApp1,1);
    mobileAppIntegerMap.put(mobileApp2,2);
    mobileAppIntegerMap.put(mobileApp3,3);
    appsUnderReview = new ArrayList<>();
    appStore = new AppStore(mobileAppIntegerMap, appsUnderReview);
  }

  @Test
  public void mysteryMethod() {
    List<MobileApp> expected = new ArrayList<>();
    expected.add(mobileApp1);
    assertEquals(expected, appStore.mysteryMethod(appCategory1,requestedDate));
  }

  @Test
  public void filterByRequestedPermissions() {
    Integer MAX_NUM_PERMISSIONS = 2;
    String permission1 = "1";
    String permission2 = "2";
    String permission3 = "3";
    String permission4 = "4";
    String permission5 = "5";

    requestedPermissions = new ArrayList<>();
    requestedPermissions.add(permission1);
    mobileApp1 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);
    requestedPermissions = new ArrayList<>();
    requestedPermissions.add(permission2);
    mobileApp2 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);
    requestedPermissions = new ArrayList<>();
    requestedPermissions.add(permission3);
    requestedPermissions.add(permission4);
    requestedPermissions.add(permission5);
    mobileApp3 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);
    requestedPermissions = new ArrayList<>();
    requestedPermissions.add(permission3);
    requestedPermissions.add(permission4);
    mobileApp4 = new MobileApp(appName,appCategory1,currentVersion,currentSize,developers,
        requestedPermissions,dateOfOriginalRelease1,dateOfLatestUpdate);

    appsUnderReview = new ArrayList<>();
    appsUnderReview.add(mobileApp1);
    appsUnderReview.add(mobileApp2);
    appsUnderReview.add(mobileApp3);
    appsUnderReview.add(mobileApp4);
    appStore = new AppStore(mobileAppIntegerMap, appsUnderReview);
    List<MobileApp> expected = new ArrayList<>();
    expected.add(mobileApp4);
    assertEquals(expected, appStore.filterByRequestedPermissions(
        MAX_NUM_PERMISSIONS,permission1,permission2));
  }
}