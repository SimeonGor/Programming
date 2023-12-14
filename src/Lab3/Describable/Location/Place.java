package Lab3.Describable.Location;

import Lab3.Describable.Describable;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Place extends Describable implements Decoratable {
    protected List<Decoration> decorations = new Vector<>();
    private TimeOfDay timeOfDay;

    Place(String description, Decoration ... decorations) {
        this.description = description;
        this.setDecorations(decorations);
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
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
}
