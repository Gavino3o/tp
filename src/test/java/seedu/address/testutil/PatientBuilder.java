package seedu.address.testutil;

import seedu.address.model.person.MedicalHistory;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Specialty;

/**
 * A utility class to help with building Patient objects.
 */
public class PatientBuilder extends PersonBuilder {
    public static final String DEFAULT_MEDICAL_HISTORY = "Osteoporosis";
    private MedicalHistory medicalHistory;

    /**
     * Constructor that assigns a default specialty.
     */
    public PatientBuilder() {
        super();
        medicalHistory = new MedicalHistory(DEFAULT_MEDICAL_HISTORY);
    }

    /**
     * Constructor to copy a specific patient.
     * @param patientToCopy
     */
    public PatientBuilder(Patient patientToCopy) {
        super(patientToCopy);
        medicalHistory = patientToCopy.getMedicalHistory();
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    /**
     * Sets the {@code MedicalHistory} of the {@code Patient} that we are building.
     * @param medicalHistory
     * @return PersonBuilder with specialty
     */
    public PersonBuilder withMedicalHistory(String medicalHistory) {
        this.medicalHistory = new MedicalHistory(medicalHistory);
        return this;
    }

    @Override
    public Patient build() {
        return new Patient(getName(), getPhone(), getEmail(), getAddress(), getTags(), getMedicalHistory());
    }

}
