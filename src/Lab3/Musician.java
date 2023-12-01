package Lab3;

import Lab3.MusicalInstrument.MusicalInstrument;

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
    public String play(MusicalInstrument instrument) {
        return instrument.play();
    }
    @Override
    public String play() {
        if (instrument != null) {
            return (this + " " + play(instrument));
        }
        else {
            return (this + " does not hold a musical instrument");
        }
    }

    @Override
    public String hold(MusicalInstrument instrument) {
        return instrument.hold();
    }
    @Override
    public String hold() {
        if (instrument != null) {
            return (this + " " + hold(instrument));
        }
        else {
            return (this + " does not hold a musical instrument");
        }
    }
}
