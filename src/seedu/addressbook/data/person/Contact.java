package seedu.addressbook.data.person;

/**
 * Represents a Person's common details in a contact field in the address book.
 *
 */
public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Returns string value of the contact field of Person.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Sets string value of the contact field of Person.
     */
    void setValue(String value) {
        this.value = value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
