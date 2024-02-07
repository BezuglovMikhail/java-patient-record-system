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

    public static Specialization fromString(String value) {
        if (value != null) {
            for(Specialization sp : Specialization.values()) {
                if (value.equalsIgnoreCase(sp.name())) {
                    return sp;
                }
            }
        }
        throw new RuntimeException();
    }

    public String getTitle() {
        return title;
    }
}
