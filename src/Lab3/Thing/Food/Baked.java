package Lab3.Thing.Food;

public class Baked extends FoodDecorator {
    public Baked(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "baked " + food.getDescription();
    }

    @Override
    public double getTaste() {
        return food.getTaste() + 35.;
    }
}
