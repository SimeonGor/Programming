package Lab3.Location;

public class Tent implements Decoration {
    private final String description;

    public Tent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public double getIndexOfAtmosphere() {
        return 10;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
