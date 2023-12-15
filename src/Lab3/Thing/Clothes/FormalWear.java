package Lab3.Thing.Clothes;

public class FormalWear extends Clothes {
    public enum Type {
        SHIRT("shirt"),
        SUIT("suit");

        private final String description;
        Type(String description) {
            this.description = description;
        };
    }

    public FormalWear(Type type) {
        this.description = type.description;
    }

    @Override
    public double getBonusCharm() {
        return 10;
    }
}
