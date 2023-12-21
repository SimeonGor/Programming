package Lab3.Music;

import Lab3.Musician;
import Lab3.Thing.MusicalInstrument.MusicalInstrument;
import Lab3.Thing.StealingException;

public interface IMusician {
    MusicalInstrument getMusicalInstrument();

    void takeMusicalInstrument(MusicalInstrument instrument) throws StealingException;
    void playOn(MusicalInstrument instrument);
    void play();
    void hold(MusicalInstrument instrument);
    void hold();
}
