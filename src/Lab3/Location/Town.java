package Lab3.Location;

import java.util.List;
import java.util.Vector;

public class Town extends Location {
    private final List<Place> places = new Vector<>();

    public Town(String description) {
        this.description = description;
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public void deletePlace(Place place) {
        places.remove(place);
    }

    public List<Place> getPlaces() {
        return places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        Town other = (Town) o;
        return this.description.equals(other.description) && this.places.equals(other.places);
    }

    @Override
    public int hashCode() {
        return this.description.hashCode() << 10 + this.places.hashCode();
    }

    @Override
    public String toString() {
        return "Town " + description + ". Map : " + places;

    }
}
