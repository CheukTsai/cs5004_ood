package controllerModules.commandOpreration;

import controllerModules.exceptions.InvalidCommandExceptions.InvalidArgumentsException;
import controllerModules.exceptions.InvalidCommandExceptions.LackArgumentsException;
import java.util.ArrayList;
import java.util.List;
import controllerModules.commandChecking.CommandChecker;

import java.util.HashMap;
import java.util.Map;

/**
 * Processes and validates command line arguments.
 * \This class doesn't *do* anything with the values provided by the user
 * beyond initial validation.
 * It is another class' responsibility to determine what to do with the user input.
 *
 * NOTE: This class is NOT modular or easily extendable.
 * This issue is not being addressed because it's too close to your
 * homework assignments.
 */
public class CommandLineParser {

  private Map<String, String> commandStringInfoMap = new HashMap<>();
  private List<Integer> completeTodoList = new ArrayList<>();
  private CommandInfoCollection commandInfoCollection;
  private Integer commandLineLength;

  /**
   * Constructor for the tool.commandOpreration.CommandLineParser class
   * @param args The arguments provided by the user.
   * @throws InvalidArgumentsException If the arguments supplied are invalid.
   */
  public CommandLineParser(String[] args)
      throws Exception {
    commandLineLength = 0;
    this.processArgs(args);
    commandInfoCollection = new CommandInfoCollection(commandStringInfoMap);
    commandInfoCollection.setCompleteTodoList(completeTodoList);
  }

  /**
   * Helper method to populate the instance variables.
   * @param args The args supplied by the user.
   * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
   */
  private void processArgs(String[] args) throws
      Exception {
    CommandOptions commandOptions = new CommandOptions();
    Map<String, Integer> optionMap = commandOptions.initialize();

    for (int i = 0; i < args.length; i++) {
      checkCommandLength(optionMap, args, i);
      addCompleteTodoToList(args[i]);
    }
    CommandChecker commandChecker = new CommandChecker(commandStringInfoMap);
    commandChecker.checkAll();
    if(commandLineLength != args.length)
      throw new InvalidArgumentsException("You have put in an illegal command");
  }

  /**
   * A helper function that helps to check the length of command.
   * @param optionMap Map, optionMap
   * @param args String[] args
   * @param index Integer index
   * @throws Exception throw exception when condition is reached
   */
  private void checkCommandLength(Map<String, Integer> optionMap, String[] args, Integer index)
      throws Exception {
    String command = args[index];
    Integer secondTwo = 2;
    if (optionMap.containsKey(command)) {
      if (optionMap.get(command) == 1) {
        commandStringInfoMap.put(command, "");
        commandLineLength++;
      }
      if (optionMap.get(command) == secondTwo) {
        try {
          index++;
          String commandArgument = args[index];
          if (optionMap.containsKey(commandArgument)) {
            throw new LackArgumentsException(
                "No argument is provided by " + command);}
          commandLineLength++;
          while(index+1 < args.length) {
            index++;
            if(optionMap.containsKey(args[index])) break;
            commandArgument += " ";
            commandArgument += args[index];
            commandLineLength++;
          }
          if(commandArgument.contains("-")) throw new
              InvalidArgumentsException("You have put in an illegal command");
          commandStringInfoMap.put(command, commandArgument);
          commandLineLength++;
        } catch (IndexOutOfBoundsException e) {
          throw new InvalidArgumentsException ("No argument is provided by " + command);
        }
      }
    }
  }

  /**
   * A helper function that helps to add command to TodoList.
   * @param command String
   */
  private void addCompleteTodoToList(String command) {
    if (command.equals(CommandOptions.D_COMPLETE_TODO)) {
      try {
        completeTodoList.add(Integer.parseInt(commandStringInfoMap.get(command)));
      } catch (NumberFormatException e) {
        throw new NumberFormatException("Id should be an Integer");
      }
    }
  }


  /**
   * Return CompleteTodoList
   * @return List
   */
  public CommandInfoCollection getCommandInfoCollection() {
    return commandInfoCollection;
  }

}
