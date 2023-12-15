package Lab3.Thing.Clothes;

public class Clean extends ClothesDecorator {
    Clean(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String getDescription() {
        return "clean " + clothes.getDescription();
    }

    @Override
    public double getBonusCharm() {
        return clothes.getBonusCharm() + 5;
    }
}
