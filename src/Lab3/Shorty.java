package Lab3;

import Lab3.Location.Place;
import Lab3.Speech.Talkable;
import Lab3.Speech.Speech;
import Lab3.Thing.Clothes.Clothes;
import Lab3.Thing.Ownable;
import Lab3.Thing.Owner;
import Lab3.Thing.StealingException;

import java.util.List;
import java.util.Vector;

public class Shorty extends Person implements Owner, Talkable {
    private Place location;
    private List<Ownable> things = new Vector<>();
    private List<Clothes> clothing = new Vector<>();
    private Hairstyle hairstyle;

    public Shorty() {
        super();
    }

    public Shorty(String name, Gender gender) {
        super(name, gender);
    }

    public List<Clothes> getClothing() {
        return clothing;
    }

    public void changeClothing(Clothes ... clothing) throws StealingException {
        this.clothing.clear();
        putOnClothing(clothing);
    }

    public void putOnClothing(Clothes ... clothing) throws StealingException {
        System.out.println(this + " is changing clothes for ...");
        for (var e : clothing) {
            this.clothing.add(e);
            this.takeThing(e);
            System.out.println("\t " + e);
        }
    }

    public Place getLocation() {
        return location;
    }

    public void goTo(Place location) {
        System.out.println(this + " is going to " + location);
        this.location = location;
    }

    public void doHairstyle(Hairstyle hairstyle) {
        System.out.println(this + " do " + hairstyle);
        this.hairstyle = hairstyle;
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }

    @Override
    public void takeThing(Ownable o) throws StealingException {
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
    public void speak(Speech speech) {
        System.out.println(speech.getSpeech());
    }

    @Override
    public String toString() {
        return (getGender() == Gender.MALE ? "коротышка" : "малышка") + " " + getName();
    }
}
