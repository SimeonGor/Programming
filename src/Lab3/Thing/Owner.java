package Lab3.Thing;

import java.util.List;
import java.util.Map;

public interface Owner {
    void takeThing(String key, Thing o) throws StealingException;
    void unlinkThing(String key);
    Map<String, Thing> getThings();
}
