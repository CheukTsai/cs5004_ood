package controllerModules.csvOperation;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

/**
 * A class that represents FileCreator.
 */
public class FileCreatorUtils {
  public static void create(String dir) throws Exception {
    if(dir != "") {
      dir.replaceAll("/", Matcher.quoteReplacement(File.separator));
      try {
        File newFile = new File(dir);
        if (!newFile.exists()) {
          newFile.createNewFile();
        }
      } catch (IOException e) {
        throw new IllegalArgumentException("No such directory has been found");
      }
    }
  }
}
