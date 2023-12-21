package Lab3.Thing;

public class StealingException extends RuntimeException {
    private final Ownable object;
    private final Owner thief;
    public StealingException(Owner thief, Ownable object) {
        super(thief + " tried to steal " + object + " from " + object.getOwner());
        this.thief = thief;
        this.object = object;
    }

    public Ownable getObject() {
        return object;
    }

    public Owner getThief() {
        return thief;
    }
}
