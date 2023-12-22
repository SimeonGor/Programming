package Lab3.Thing;

import java.util.List;
import java.util.Vector;

public class Notebook extends Thing implements KeepingNotes {
    private final int maxCountOfMemory;
    private final List<String> notes = new Vector<>();

    public Notebook(int maxCountOfNotes) {
        this.maxCountOfMemory = maxCountOfNotes;
    }

    @Override
    public void addNote(String note) {
        if (notes.size() < maxCountOfMemory) {
            notes.add(note);
        }
    }

    @Override
    public List<String> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Notebook other = (Notebook) o;
        return other.notes.equals(this.notes) && other.maxCountOfMemory == this.maxCountOfMemory;
    }

    @Override
    public int hashCode() {
        return notes.hashCode() << 8 + maxCountOfMemory;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("the notebook (" + notes.size() + "/" + maxCountOfMemory + ") contains notes : ");
        for (var e : notes) {
            result.append("\n\t").append(e);
        }
        return result.toString();
    }
}
