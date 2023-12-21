package Lab3.Thing.Food;

public abstract class FoodDecorator extends Food {
    protected Food food;

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getTaste();
}
