package Lab3.Thing.Clothes;

public class Ironed extends ClothesDecorator {
    Ironed(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getDescription() {
        return "ironed" + clothes.getDescription();
    }

    @Override
    public double getBonusCharm() {
        return clothes.getBonusCharm() + 3;
    }
}
