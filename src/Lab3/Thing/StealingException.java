package Lab3.Thing;

public class StealingException extends RuntimeException {
    private final Thing object;
    private final Owner thief;
    public StealingException(Owner thief, Thing object) {
        super(thief + " tried to steal " + object + " from " + object.getOwner());
        this.thief = thief;
        this.object = object;
    }

    public Thing getObject() {
        return object;
    }

    public Owner getThief() {
        return thief;
    }
}
