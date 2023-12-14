package Lab3.Thing;

import java.util.Vector;

public interface Owner {
    void getThing(Ownable o);
    void unlinkThing(Ownable o);

    Vector<Ownable> getThings();
}
