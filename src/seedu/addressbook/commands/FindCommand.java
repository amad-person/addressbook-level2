package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    public FindCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());

            final ArrayList<String> wordsInNameIgnoreCase = getListInLowerCase(wordsInName);
            final ArrayList<String> keywordsIgnoreCase = getListInLowerCase(keywords);

            if (!Collections.disjoint(wordsInNameIgnoreCase, keywordsIgnoreCase)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Returns list of strings after converting each string to lower case
     *
     * @param strings for converting into lower case
     * @return list of strings in lower case
     */
    private ArrayList<String> getListInLowerCase(Set<String> strings) {
        ArrayList<String> stringsIgnoreCase = new ArrayList<>();

        for(String str : strings) {
            stringsIgnoreCase.add(str.toLowerCase());
        }

        return stringsIgnoreCase;
    }
}
