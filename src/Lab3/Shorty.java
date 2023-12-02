package Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Shorty {
    protected String name;
    protected Gender gender;
    protected Location location;
    protected ArrayList<Clothes> clothing = new ArrayList<>();
    protected ArrayList<Appearance> appearances = new ArrayList<>();
    protected Hairstyle hairstyle;

    public Shorty() {
        this("Безымянный", ((new Random()).nextBoolean() ? Gender.FEMALE : Gender.MALE));
    }

    public Shorty(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Clothes> getClothing() {
        return clothing;
    }

    public void setClothing(Clothes ... clothing) {
        this.clothing.addAll(Arrays.asList((clothing)));
    }

    public void addClothing(Clothes clothes) {
        this.clothing.add(clothes);
    }

    public ArrayList<Appearance> getAppearances() {
        return appearances;
    }

    public void setAppearances(Appearance... conditions) {
        this.appearances.addAll(Arrays.asList(conditions));
    }

    public void addAppearances(Appearance condition) {
        this.appearances.add(condition);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setHairstyle(Hairstyle hairstyle) {
        this.hairstyle = hairstyle;
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Shorty other = ((Shorty) o);
        return this.name.equals(other.getName()) && this.gender == other.gender;
    }

    @Override
    public String toString() {
        return (this.gender == Gender.FEMALE ? "малышка" : "коротышка") + " " + this.name;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
