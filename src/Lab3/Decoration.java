package Lab3;

public enum Decoration {
    FLOWERS("flowers"),
    NOTHING("nothing");

    private final String description;
    Decoration(String description) {this.description = description;}
    public String getDescription() { return this.description; }
}
