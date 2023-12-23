package Lab3;

public enum Hairstyle {
    PROTRUDING_TUFT("торчащий вихор"),
    PIGTAIL("косичка"),
    SHORT("короткие волосы"),
    MESSY("растрепанная прическа"),
    OTHER("другая прическа");

    private final String description;

    Hairstyle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
