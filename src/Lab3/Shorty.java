package Lab3;

import Lab3.Location.Place;
import Lab3.Thing.Clothes.Clothes;
import Lab3.Thing.Ownable;
import Lab3.Thing.Owner;
import Lab3.Thing.Thing;

import java.util.List;
import java.util.Arrays;
import java.util.Vector;

public class Shorty extends Person implements Owner {
    protected Place location;
    protected List<Ownable> things = new Vector<>();
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
        putOnClothing(clothing);
    }

    public void putOnClothing(Clothes ... clothing) {
        for (var e : clothing) {
            this.clothing.add(e);
            this.takeThing(e);
        }
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

    @Override
    public void takeThing(Ownable o) {
        this.things.add(o);
        o.setOwner(this);
    }

    @Override
    public void unlinkThing(Ownable o) {
        this.things.remove(o);
        o.unsetOwner();
    }

    @Override
    public List<Ownable> getThings() {
        return this.things;
    }

    @Override
    public String toString() {
        return (gender == Gender.MALE ? "коротышка" : "малышка") + " " + name;
    }
}
