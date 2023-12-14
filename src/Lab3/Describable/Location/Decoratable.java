package Lab3.Describable.Location;

import java.util.Arrays;
import java.util.List;

public interface Decoratable {
    List<Decoration> getDecoration();
    void setDecorations(Decoration ... decorations);
    void addDecorations(Decoration ... decorations);
}
