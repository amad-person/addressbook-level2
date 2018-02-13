package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;

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

    /** Returns divider for formatting */
    public static String getFormatDivider() {
        return DIVIDER;
    }

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
        return "[Command entered:" + fullInputLine + "]";
    }

    /** Returns formatted string of storage file path. */
    public static String getFormattedStorageFileInfo(String storageFilePath) {
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }

    /** Shows message(s) to the user. */
    public static String formatShowToUser(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
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

        return formatted.toString();
    }

    /** Returns formatted string of each list item. */
    private static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
