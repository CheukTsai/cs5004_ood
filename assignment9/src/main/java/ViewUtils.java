import java.util.Scanner;

/**
 * A class of View.
 */
public class ViewUtils {
  /**
   * Asks the user for input.
   * @param prompt A message to show to the user before getting their input.
   * @return The user's input
   */
  public static String getInput(String prompt) {
    Scanner scan = new Scanner(System.in);
    System.out.println(prompt);
    return scan.nextLine();
  }

}
