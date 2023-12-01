package Lab3;

public enum TimeOfDay {
    MORNING("утро"),
    AFTERNOON("обед"),
    EVENING("вечер"),
    HIGHT("поздний вечер");
    private final String description;

    TimeOfDay(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
