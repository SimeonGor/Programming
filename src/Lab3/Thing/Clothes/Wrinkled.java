package Lab3.Thing.Clothes;

public class Wrinkled extends ClothesDecorator {
    public Wrinkled(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getDescription() {
        return "wrinkled " + clothes.getDescription();
    }

    @Override
    public double getBonusCharm() {
        return clothes.getBonusCharm() - 5;
    }
}
