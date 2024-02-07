package ru.bezuglov.until;

public enum TicketStatus {

    BLOCK("Талон забронирован"),
    UNBLOCK("Талон свободен");

    private String title;

    TicketStatus(String title) {
        this.title = title;
    }

    public static TicketStatus fromString(String value) {
        if (value != null) {
            for(TicketStatus sp : TicketStatus.values()) {
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
