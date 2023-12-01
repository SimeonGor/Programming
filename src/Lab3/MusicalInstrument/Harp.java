package Lab3.MusicalInstrument;

public abstract class Harp implements MusicalInstrument{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
