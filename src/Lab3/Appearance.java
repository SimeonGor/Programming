package Lab3;

public enum Appearance {
    WASHED("умытый"),
    COMBED("причесанный"),
    NOTHING_SPECIAL("ничего особенного");

    private final String description;

    Appearance(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
