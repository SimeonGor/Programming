package Lab3;

public class Hit implements Attack {
    private double damage;
    private Object opponent;

    public Hit(double damage, Object opponent) {
        this.damage = damage;
        this.opponent = opponent;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public Object getOpponent() {
        return opponent;
    }
}
