package Lab3;

import Lab3.Music.IMusician;
import Lab3.Thing.MusicalInstrument.MusicalInstrument;

public class Musician extends Shorty implements IMusician {
    protected MusicalInstrument instrument = null;

    Musician(String name, Gender gender) {
        super(name, gender);
    }

    Musician(MusicalInstrument instrument) {
        this.instrument = instrument;
    }

    public void setMusicalInstrument(MusicalInstrument instrument) {
        this.instrument = instrument;
    }

    public MusicalInstrument getMusicalInstrument() {
        return instrument;
    }

    @Override
    public void playOn(MusicalInstrument instrument) {

    }
    @Override
    public void play() {

    }

    @Override
    public void hold(MusicalInstrument instrument) {

    }
    @Override
    public void hold() {

    }
}
