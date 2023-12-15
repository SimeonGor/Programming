package Lab3.Location;

import java.util.List;

public interface Decoratable {
    List<Decoration> getDecoration();
    void setDecorations(Decoration ... decorations);
    void addDecorations(Decoration ... decorations);
    double getIndexOfAtmosphere();
}
