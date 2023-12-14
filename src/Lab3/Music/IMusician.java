package Lab3.Music;

import Lab3.Thing.MusicalInstrument.MusicalInstrument;

public interface IMusician {
    void playOn(MusicalInstrument instrument);
    void play();
    void hold(MusicalInstrument instrument);
    void hold();
}
