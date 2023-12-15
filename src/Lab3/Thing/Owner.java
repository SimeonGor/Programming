package Lab3.Thing;

import java.util.List;

public interface Owner {
    void takeThing(Ownable o);
    void unlinkThing(Ownable o);
    List<Ownable> getThings();
}
