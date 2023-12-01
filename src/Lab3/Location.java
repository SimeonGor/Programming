package Lab3;

public enum Location {
    SECOND_FLOOR("второй этаж беседки"),
    PLATFORM("площадка"),
    NOWHERE("нигде");
    private Decoration decoration;
    private final String description;

    Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }
}
