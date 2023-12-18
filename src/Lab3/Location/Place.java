package Lab3.Location;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Place implements Decoratable {
    private String description;
    private List<Decoration> decorations = new Vector<>();
    private TimeOfDay timeOfDay;

    public Place(String description, Decoration ... decorations) {
        this.description = description;
        this.setDecorations(decorations);
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        int sum = 0;
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
        String str = getDescription() + " decorated with";
        for (var e : decorations) {
            str += " " + e;
        }
        str += " at " + timeOfDay;
        return str;
    }

    @Override
    public int hashCode() {
        return (this.decorations.hashCode() << 2) + (this.timeOfDay.hashCode() << 1) + this.description.hashCode();
    }
}
