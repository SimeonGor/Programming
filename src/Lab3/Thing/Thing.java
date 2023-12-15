package Lab3.Thing;

public abstract class Thing implements Ownable {
    private Owner owner;
    @Override
    public void setOwner(Owner o) {
        this.owner = o;
        o.getThing(this);
    }

    @Override
    public void unsetOwner() {
        owner.unlinkThing(this);
        owner = null;
    }

    @Override
    public Owner getOwner() {
        return owner;
    }
}
