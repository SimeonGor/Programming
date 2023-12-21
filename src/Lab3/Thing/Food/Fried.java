package Lab3.Thing.Food;

public class Fried extends FoodDecorator {
    public Fried(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "fried " + food.getDescription();
    }

    @Override
    public double getTaste() {
        return food.getTaste() + 30;
    }
}
