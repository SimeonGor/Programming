package Lab3;

import Lab3.MusicalInstrument.MusicalInstrument;

public interface IMusician {
    String play(MusicalInstrument instrument);
    String play();
    String hold(MusicalInstrument instrument);
    String hold();
}
