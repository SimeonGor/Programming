package Lab3.Location;

public class Plants implements Decoration {
    public enum Type {
        FLOWERS("flowers", 10),
        TREES("trees", 20),
        BUSHES("bushes", 15);

        private final int index;
        private final String description;

        Type(String description, int index) {
            this.index = index;
            this.description = description;
        }
    }

    private Type type;

    public Plants(Type type) {
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
        return ((Plants) o).getType() == this.getType();
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return type.description;
    }
}
