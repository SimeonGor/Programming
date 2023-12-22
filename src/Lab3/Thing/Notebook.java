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
    public void interact() {}
}
