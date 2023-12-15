package Lab3.Thing.Clothes;

public class Dirty extends ClothesDecorator {
    public Dirty(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getDescription() {
        return "dirty" + clothes.getDescription();
    }

    @Override
    public double getBonusCharm() {
        return clothes.getBonusCharm() - 7;
    }
}
