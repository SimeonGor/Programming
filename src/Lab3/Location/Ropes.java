package Lab3.Location;

public class Ropes implements Decoration {
    public enum Type {
        FLAGS("flags", 10.),
        LANTERNS("lanterns", 11.);
        private final String description;
        private final double index;

        Type(String description, double index) {
            this.index = index;
            this.description = description;
        }
    }

    private Type type;

    public Ropes(Type type) {
        this.type = type;
    }

    @Override
    public double getIndexOfAtmosphere() {
        return type.index;
    }

    public String getDescription() {
        return type.description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        return ((Ropes) o).getType() == this.getType();
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "ropes with " + type.description;
    }
}
