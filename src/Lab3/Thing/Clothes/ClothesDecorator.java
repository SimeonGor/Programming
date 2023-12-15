package Lab3.Thing.Clothes;

public abstract class ClothesDecorator extends Clothes {
    protected Clothes clothes;
    @Override
    public abstract String getDescription();
}
