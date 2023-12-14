package Lab3.Thing;

public interface Ownable {
    void setOwner(Owner o);
    void unsetOwner();
    Owner getOwner();
}
