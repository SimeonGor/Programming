package Lab3.Thing;

public abstract class Thing implements Ownable, Interactable {
    private Owner owner;
    @Override
    public void setOwner(Owner o) throws StealingException {
        if (owner != null && owner != o) {
            throw new StealingException(o, this);
        }
        this.owner = o;
    }

    @Override
    public void unsetOwner() {
        this.owner = null;
    }

    @Override
    public Owner getOwner() {
        return owner;
    }
}
