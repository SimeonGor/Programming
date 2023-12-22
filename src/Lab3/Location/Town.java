package Lab3.Location;

import java.util.HashMap;
import java.util.Map;

public class Town extends Location {
    private final Map<String, Place> places = new HashMap<>();

    public Town(String description) {
        this.description = description;
    }

    public void addPlace(String key, Place place) {
        places.put(key, place);
    }

    public void deletePlace(String key) {
        places.remove(key);
    }

    public Map<String, Place> getPlaces() {
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
