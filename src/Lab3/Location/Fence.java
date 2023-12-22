package Lab3.Location;

import Lab3.Thing.KeepingNotes;

import java.util.List;
import java.util.Vector;

public class Fence implements KeepingNotes, Decoration {
    private String description;
    private final List<String> notes = new Vector<>();

    public Fence(String description) {
        this.description = description;
    }

    @Override
    public double getIndexOfAtmosphere() {
        return -1 * notes.size();
    }

    @Override
    public void addNote(String note) {
        notes.add(note);
    }

    @Override
    public List<String> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Fence other = (Fence) o;
        return this.notes.equals(other.notes) && this.description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return notes.hashCode() << 5 + description.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("the fence");
        if (!notes.isEmpty()) {
            str.append(" with notes:");
            for (var e: notes) {
                str.append(" ").append(e);
            }
        }
        return String.valueOf(str);
    }
}
