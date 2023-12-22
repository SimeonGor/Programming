package Lab3.Thing.Food;

import Lab3.Thing.Thing;

public abstract class Food extends Thing implements Edible {
    protected String description;
    protected double taste;

    public double getTaste() {
        return taste;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void eat() {
        System.out.println("eating " + this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Food other = (Food) o;
        return other.description.equals(this.description) && other.taste == this.taste;
    }

    @Override
    public int hashCode() {
        return description.hashCode() << 8 + (int)taste;
    }

    @Override
    public String toString() {
        return getDescription() + " (" +  getTaste() + "/100)";
    }
}
