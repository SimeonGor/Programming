package Lab3.Thing.Clothes;

public class WomenClothing extends Clothes {
    public enum Type {
        DRESS("dress"),
        SKIRT("skirt");

        private final String description;
        Type(String description) {
            this.description = description;
        };
    }

    public WomenClothing(Type type) {
        this.description = type.description;
    }

    @Override
    public double getBonusCharm() {
        return 10;
    }
}
