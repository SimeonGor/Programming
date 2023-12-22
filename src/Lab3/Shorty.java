package Lab3;

import Lab3.Location.Place;
import Lab3.Speech.Talkable;
import Lab3.Speech.Speech;
import Lab3.Thing.Clothes.Clothes;
import Lab3.Thing.Ownable;
import Lab3.Thing.Owner;
import Lab3.Thing.StealingException;

import java.util.HashMap;
import java.util.Map;

public class Shorty extends Person implements Owner, Talkable {
    private Place location;
    private final Map<String, Ownable> things = new HashMap<>();
    private final Map<String, Clothes> clothing = new HashMap<>();
    private Hairstyle hairstyle;

    public Shorty() {
        super();
    }

    public Shorty(String name, Gender gender) {
        super(name, gender);
    }

    public Map<String, Clothes> getClothing() {
        return clothing;
    }

    public void deleteClothing(String key) {
        System.out.println(this + " is changing clothes for ...");
        unlinkThing(key);
        clothing.remove(key);
    }

    public void setClothing(String key, Clothes clothes ) throws StealingException {
        System.out.println(this + " is putting on ...");
        if (clothing.containsKey(key)) {
            deleteClothing(key);
        }
        takeThing(key, clothes);
        clothing.put(key, clothes);
    }

    public Place getLocation() {
        return location;
    }

    public void goTo(Place location) {
        System.out.println(this + " is going to " + location);
        this.location = location;
    }

    public void setHairstyle(Hairstyle hairstyle) {
        System.out.println(this + " do " + hairstyle);
        this.hairstyle = hairstyle;
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }

    @Override
    public void takeThing(String key, Ownable o) throws StealingException {
        o.setOwner(this);
        this.things.put(key, o);
    }

    @Override
    public void unlinkThing(String key) {
        things.get(key).unsetOwner();
        this.things.remove(key);
    }

    @Override
    public Map<String, Ownable> getThings() {
        return this.things;
    }

    @Override
    public Speech speak(Speech speech) {
        System.out.println(speech.getSpeech());
        return speech;
    }

    @Override
    public String toString() {
        return (getGender() == Gender.MALE ? "коротышка" : "малышка") + " " + getName();
    }
}
