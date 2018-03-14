package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Associates a Tag to a Person by storing a {@code tag} that is added or deleted from a {@code person}.
 */
public class Tagging {

    private Person person;
    private Tag tag;
    private String statusTagging;

    private final String WHITESPACE = " ";

    public Tagging (Person person, Tag tag, String statusTagging) {
        this.person = person;
        this.tag = tag;
        this.statusTagging = statusTagging.equals("add") ? "+" : "-";
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public String getStatusTagging() {
        return statusTagging;
    }

    public String getTagging() {
        return statusTagging + WHITESPACE + getPerson().getName().toString() + WHITESPACE + getTag().toString();
    }
}
