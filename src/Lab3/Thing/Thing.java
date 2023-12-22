package Lab3.Thing;

public abstract class Thing {
    private Owner owner;

    public void setOwner(Owner o) throws StealingException {
        if (owner != null && owner != o) {
            throw new StealingException(o, this);
        }
        this.owner = o;
    }

    public void unsetOwner() {
        this.owner = null;
    }

    public Owner getOwner() {
        return owner;
    }
}
