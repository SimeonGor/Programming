package Lab3;

import Lab3.Thing.KeepingNotes;
import Lab3.Thing.Thing;

public interface Writer {
    default void writeIn(Thing thing, String note) throws InvalidThingInterfaceException {
        if (!(thing instanceof KeepingNotes)) {
            throw new InvalidThingInterfaceException(thing, KeepingNotes.class.getName());
        }

        KeepingNotes notebook = (KeepingNotes) thing;
        notebook.addNote(note);
    }
}
