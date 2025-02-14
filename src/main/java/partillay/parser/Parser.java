package partillay.parser;

import partillay.command.*;

import partillay.exception.*;

import partillay.task.*;

/**
 * Represents a parser that processes user inputs to return {@code Command} to be executed.
 */
public class Parser {

    /**
     * Parses the user's input string and returns the corresponding {@code Command}.
     * <p>
     * Supports commands such as {@code bye}, {@code list}, {@code mark}, {@code unmark},
     * {@code delete}, {@code todo}, {@code deadline}, and {@code event}. If the input
     * does not match any valid command format, an exception is thrown.
     * </p>
     *
     * @param userInput the raw input string from the user
     * @return a {@code Command} object representing the parsed command
     * @throws PartillayException if the input does not match any valid command format
     */
    public static Command parse(String userInput) throws PartillayException {
        if (userInput.trim().equals("bye")) {
            return new ByeCommand();
        } else if (userInput.trim().equals("list")) {
            return new ShowTaskListCommand();
        } else if (userInput.startsWith("find")) {
            String toBeSearched = userInput.substring(4);
            if (!toBeSearched.startsWith(" ") && !toBeSearched.isEmpty()) {
                throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
            }
            toBeSearched = toBeSearched.trim();
            if (toBeSearched.isEmpty()) {
                throw new PartillayIncompleteDescriptionException("Bestie, your keyword cannot be empty!");
            }
            return new FindCommand(toBeSearched);
        } else if (userInput.startsWith("mark")) {
            int taskIndexToMark;
            try {
                taskIndexToMark = Integer.parseInt(userInput.substring(5));
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            return new MarkCommand(taskIndexToMark);
        } else if (userInput.startsWith("unmark")) {
            int taskIndexToUnmark;
            try {
                taskIndexToUnmark = Integer.parseInt(userInput.substring(7));
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            return new UnmarkCommand(taskIndexToUnmark);
        } else if (userInput.startsWith("delete")) {
            int taskIndexToDelete;
            try {
                taskIndexToDelete = Integer.parseInt(userInput.substring(7));
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            return new DeleteCommand(taskIndexToDelete);
        } else if (userInput.startsWith("todo")) {
            String description = userInput.substring(4);
            if (!description.startsWith(" ") && !description.isEmpty()) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            description = description.trim();
            if (description.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, your task cannot be empty!");
            }
            return new AddCommand(new ToDo(description));
        } else if (userInput.startsWith("deadline")) {
            String input = userInput.substring(8);
            if (!input.startsWith(" ") && !input.isEmpty()) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            input = input.trim();
            if (input.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, your task cannot be empty!");
            }
            String[] parts = userInput.substring(9).split(" /by ");
            if (parts.length != 2) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            String description = parts[0].trim();
            String by = parts[1].trim();
            if (description.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, your task cannot be empty!");
            }
            if (by.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, I need your deadline!");
            }
            return new AddCommand(new Deadline(description, by));
        } else if (userInput.startsWith("event")) {
            String input = userInput.substring(5);
            if (!input.startsWith(" ") && !input.isEmpty()) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            input = input.trim();
            if (input.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, your task cannot be empty!");
            }
            String[] parts = userInput.substring(6).split(" /from | /to ");
            if (parts.length != 3) {
                throw new PartillayInvalidCommandException(
                        "That's not a valid command, bestie!");
            }
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            if (description.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, your task cannot be empty!");
            }
            if (from.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, I need your starting time!");
            }
            if (to.isEmpty()) {
                throw new PartillayIncompleteDescriptionException(
                        "Bestie, I need your ending time!");
            }
            return new AddCommand(new Event(description, from, to));
        } else {
            throw new PartillayInvalidCommandException(
                    "That's not a valid command, bestie!");
        }
    }
}
