package Lab3;

import Lab3.Location.Place;
import Lab3.Thing.Clothes.Clothes;

import java.util.List;
import java.util.Arrays;
import java.util.Vector;

public class Shorty extends Person {
    protected Place location;
    protected List<Clothes> clothing = new Vector<>();
    protected Hairstyle hairstyle;

    public Shorty() {
        super();
    }

    public Shorty(String name, Gender gender) {
        super(name, gender);
    }

    public List<Clothes> getClothing() {
        return clothing;
    }

    public void changeClothing(Clothes ... clothing) {
        this.clothing.clear();
        this.clothing.addAll(Arrays.asList((clothing)));
    }

    public void putOnClothing(Clothes ... clothing) {
        this.clothing.addAll(Arrays.asList((clothing)));
    }

    public Place getLocation() {
        return location;
    }

    public void goTo(Place location) {
        this.location = location;
    }

    public void doHairstyle(Hairstyle hairstyle) {
        this.hairstyle = hairstyle;
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }
}
