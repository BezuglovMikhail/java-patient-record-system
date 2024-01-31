package ru.bezuglov.prs.until;

public enum Specialization {

    PAEDIATRICIAN ("Педиатр"),
    THERAPIST ("Терапевт"),
    OTOLARYNGOLOGIST ("Отоларинголог"),
    OCULIST ("Окулист"),
    SURGEON ("Хирург");

    private String title;

    Specialization(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
