package Lab3;

public enum Clothes {
    CLEAN_SHIRT("чистенькая рубашка"),
    SOMETHING("что-то");

    private final String description;

    Clothes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
