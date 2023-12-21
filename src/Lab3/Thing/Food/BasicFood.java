package Lab3.Thing.Food;

public class BasicFood extends Food {
    public enum Type {
        VEGETABLE("vegetable"),
        FRUIT("fruit"),
        BERRY("berry"),
        MEAT("meat"),
        FISH("fish");

        private final String description;
        Type(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    Type type;
    public BasicFood(String description, double taste, Type type) {
        this.description = description;
        this.taste = taste;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " " + super.toString();
    }
}
