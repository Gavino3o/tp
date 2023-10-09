package seedu.address.model.person;


import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Specialist in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Specialist extends Person {
    private final Specialty specialty;

    /**
     * Every field must be present and not null.
     */
    public Specialist(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Specialty specialty) {
        super(name, phone, email, address, tags);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", super.getName())
                .add("phone", super.getPhone())
                .add("email", super.getEmail())
                .add("address", super.getAddress())
                .add("tags", super.getTags())
                .add("specialty", specialty)
                .toString();
    }

    /**
     * Returns true if the other object is a specialist and have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Specialist)) {
            return false;
        }

        Specialist otherSpecialist = (Specialist) other;
        return super.getName().equals(otherSpecialist.getName())
                && super.getPhone().equals(otherSpecialist.getPhone())
                && super.getEmail().equals(otherSpecialist.getEmail())
                && super.getAddress().equals(otherSpecialist.getAddress())
                && super.getTags().equals(otherSpecialist.getTags());
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
