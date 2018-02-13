package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.ArrayList;
import java.util.List;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Returns regex for comment lines */
    public static String getCommentLineFormatRegex() {
        return COMMENT_LINE_FORMAT_REGEX;
    }

    /** Returns formatted prompt for user command. */
    public static String getFormattedUserCommandPrompt() {
        return LINE_PREFIX + "Enter command: ";
    }

    /** Returns formatted string of prompt displaying what command the user entered. */
    public static String getFormattedEnteredCommand(String fullInputLine) {
        return formatMessage(
                "[Command entered:" + fullInputLine + "]"
        );
    }

    /** Returns formatted welcome message. */
    public static String getFormattedWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessage(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER
        );
    }

    /** Returns formatted goodbye message. */
    public static String getFormattedGoodbyeMessage() {
        return formatMessage(
                MESSAGE_GOODBYE,
                DIVIDER,
                DIVIDER
        );
    }

    /** Returns formatted init failed message. */
    public static String getFormattedInitFailedMessage() {
        return formatMessage(
                MESSAGE_INIT_FAILED,
                DIVIDER,
                DIVIDER
        );
    }

    /** Returns formatted string for displaying result of command. */
    public static String getFormattedResult(CommandResult result) {
        return formatMessage(
                result.feedbackToUser,
                DIVIDER
        );
    }

    /** Creates and returns formatted message. */
    private static String formatMessage(String... message) {
        final StringBuilder formatted = new StringBuilder();

        for (String m : message) {
            formatted.append(LINE_PREFIX).append(m.replace("\n", LS + LINE_PREFIX)).append("\n");
        }

        return formatted.toString();
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getFormattedIndexedListForViewing(List<String> listItems) {
        return formatIndexedListForViewing(listItems);
    }

    /** Returns formatted string of all items in list to display. */
    private static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(formatIndexedListItem(displayIndex, listItem))
                    .append("\n");
            displayIndex++;
        }

        return formatMessage(formatted.toString());
    }

    /** Returns formatted string of each list item. */
    private static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
