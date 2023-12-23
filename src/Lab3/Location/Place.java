package Lab3.Location;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Place extends Location implements Decoratable {
    private List<Decoration> decorations = new Vector<>();

    public Place(String description, Decoration ... decorations) {
        this.description = description;
        this.setDecorations(decorations);
    }

    @Override
    public List<Decoration> getDecoration() {
        return decorations;
    }

    @Override
    public void setDecorations(Decoration ... decorations) {
        this.decorations.clear();
        this.decorations.addAll(Arrays.asList(decorations));
    }

    @Override
    public void addDecorations(Decoration ... decorations) {
        this.decorations.addAll(Arrays.asList(decorations));
    }

    @Override
    public double getIndexOfAtmosphere() {
        double sum = 0;
        for (var e : decorations) {
            sum += e.getIndexOfAtmosphere();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Place other = (Place) o;
        return this.decorations.equals(other.decorations)
                && this.timeOfDay.equals(other.timeOfDay)
                && this.description.equals(other.description);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(getDescription());
        if (!decorations.isEmpty()) {
            str.append(" decorated with");
            for (var e : decorations) {
                str.append(" ").append(e);
            }
        }

        //        str.append(" at ").append(timeOfDay);
        return str.toString();
    }

    @Override
    public int hashCode() {
        return (this.decorations.hashCode() << 2) + (this.timeOfDay.hashCode() << 1) + this.description.hashCode();
    }
}
