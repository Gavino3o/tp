package seedu.address.model.person.predicates;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Patient}'s {@code Age} matches any of the keywords given.
 */
public class AgeContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public AgeContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        if (!(person instanceof Patient)) {
            return false;
        }

        // It is safe to type cast Person to Patient due to the guard clause above.
        Patient patient = (Patient) person;
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(patient.getAge().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AgeContainsKeywordsPredicate)) {
            return false;
        }

        AgeContainsKeywordsPredicate otherAgeContainsKeywordsPredicate = (AgeContainsKeywordsPredicate) other;
        return keywords.equals(otherAgeContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}

