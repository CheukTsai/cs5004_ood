package controllerModules.exceptions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsageDisplayHelperTest {

  private static String[] flags;
  private static String[] flags2;
  private static String[][] explanations;
  private static String[][] explanations2;
  private static String[][] explanations3;
  private static String usageHelp;

  static {
    flags = new String[]{
        "REQUIRED ARGUMENTS",
        "--email",
        "",
        "--letter",
        "--letter-template <path/to/file>",
        "--output-dir<path/to/folder>",
        "--csv-file <path/to/folder>"
    };
    flags2 = new String[]{
        "REQUIRED ARGUMENTS",
        "--email",
        "--email-template <path/to/file>",
        "--letter"
    };
    explanations = new String[][]{
        {"EXPLANATION"},
        {"Generate email messages"},
        {"Need a filename for the email template"},
        {"Generate letters"},
        {"Need a filename for the letter template"},
        {"The folder to store all generated files. This option is required."},
        {"The CSV file to process. This option is required."}
    };

    explanations2 = new String[][]{
        {"EXPLANATION"},
        {"Generate email messages"},
        {"Need a filename for the email template"},
        {"Generate letters"},

    };

    explanations3 = new String[][]{
        {"EXPLANATION"},
        null,
        {"Need a filename for the email template"},
        {"Generate letters"},
        {"Need a filename for the letter template"},
        {"The folder to store all generated files. This option is required."},
        {"The CSV file to process. This option is required."},

    };
  }

  @Test
  public  void testCreateTableException() throws Exception{
    UsageDisplayHelper a = new UsageDisplayHelper();
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, flags,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException2() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(null, flags,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException3() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, null,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException4() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, null,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException5() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length, 1}, flags,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException6() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, flags2,
        explanations);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException7() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, flags,
        explanations2);
  }

  @Test(expected = Exception.class)
  public void testCreateTableException8() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, flags,
        explanations3);
  }

  @Test(expected = Exception.class)
  public  void testCreateTableException9() throws Exception{
    usageHelp = UsageDisplayHelper.createTable(new int[]
            {flags.length, explanations[0].length}, flags,
        null);
  }

}