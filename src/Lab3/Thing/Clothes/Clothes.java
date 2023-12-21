package Lab3.Thing.Clothes;


import Lab3.Thing.Thing;

public abstract class Clothes extends Thing {
    protected String description = "unknown clothes";

    public String getDescription() {
        return this.description;
    }

    public abstract double getBonusCharm();

    @Override
    public void interact() {}

    @Override
    public String toString() {
        return getDescription() + "(" + getBonusCharm() + "/100)";
    }
}
