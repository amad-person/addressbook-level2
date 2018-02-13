package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts all persons in the address book .
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts and displays all persons in the address book in alphabetical order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    /** Defines ordering by name of the person in the address book. */
    private static final Comparator<ReadOnlyPerson> PERSON_NAME_COMPARATOR = Comparator.comparing(o -> o.getName().toString());

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPersons = sortPersonListByName(addressBook.getAllPersons().immutableListView());

        return new CommandResult(getMessageForPersonListSortedShownSummary(sortedPersons), sortedPersons);
    }

    /**
     * Sorts and displays list of persons in the address book by their names.
     *
     * @param unsortedPersons list of unsorted persons in the address book.
     * @return sortedPersons list of sorted persons by name.
     */
    private List<ReadOnlyPerson> sortPersonListByName(List<ReadOnlyPerson> unsortedPersons) {
        List<ReadOnlyPerson> sortedPersons = new ArrayList<>(unsortedPersons);
        Collections.sort(sortedPersons, PERSON_NAME_COMPARATOR);

        return sortedPersons;
    }
}
