package Lab3;

import Lab3.Location.Place;
import Lab3.Location.Town;
import Lab3.Speech.Talkable;
import Lab3.Speech.Speech;
import Lab3.Thing.Clothes.Clothes;
import Lab3.Thing.Food.Food;
import Lab3.Thing.Owner;
import Lab3.Thing.StealingException;
import Lab3.Thing.Thing;

import java.util.HashMap;
import java.util.Map;

public class Shorty extends Person implements Owner, Talkable, Writer, Sleepable {
    private Town nativeTown;
    private Place location;
    private final Map<String, Thing> things = new HashMap<>();
    private final Map<String, Clothes> clothing = new HashMap<>();
    private Hairstyle hairstyle;

    private double healthPoint = 100;
    private final double maxHealthPoint = 100;

    public Shorty() {
        super();
    }

    public Shorty(String name, Gender gender, Town nativeTown) {
        super(name, gender);
        this.nativeTown = nativeTown;
    }

    public Map<String, Clothes> getClothing() {
        return clothing;
    }

    public void deleteClothing(String key) {
        System.out.println(this + " is take of " + clothing.get(key));
        unlinkThing(key);
        clothing.remove(key);
    }

    public void setClothing(String key, Clothes clothes ) throws StealingException {
        if (clothing.containsKey(key)) {
            deleteClothing(key);
        }
        takeThing(key, clothes);
        clothing.put(key, clothes);
        System.out.println(this + " is putting on " + clothes);
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

    public double getHealthPoint() {
        return healthPoint;
    }

    public void takeDamage(Attack attack) {
        healthPoint -= attack.getDamage();
        System.out.println(this + " was hit by " + attack.getOpponent());
    }

    public void eat(Food food) {
        if (healthPoint + food.getTaste() < maxHealthPoint) {
            healthPoint += food.getTaste();
        }
        else {
            healthPoint = maxHealthPoint;
        }
        System.out.println(this + " ate " + food);
    }


    @Override
    public void takeThing(String key, Thing o) throws StealingException {
        o.setOwner(this);
        this.things.put(key, o);
    }

    @Override
    public void unlinkThing(String key) {
        things.get(key).unsetOwner();
        this.things.remove(key);
    }

    @Override
    public Map<String, Thing> getThings() {
        return this.things;
    }

    @Override
    public Speech speak(Speech speech) {
        System.out.println(this + " says: \"" + speech.getSpeech() + "\"");
        return speech;
    }

    @Override
    public void sleep(String time) {
        System.out.println(this + " have been sleeping for " + time);
    }

    @Override
    public String toString() {
        return (getGender() == Gender.MALE ? "коротышка" : "малышка") + " " + getName() + "(HP : " + healthPoint + "/100)";
    }
}
