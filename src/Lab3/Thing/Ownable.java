package Lab3.Thing;

public interface Ownable {
    void setOwner(Owner o) throws StealingException;
    void unsetOwner();
    Owner getOwner();
}
