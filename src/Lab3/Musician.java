package Lab3;

import Lab3.Music.IMusician;
import Lab3.Thing.MusicalInstrument.MusicalInstrument;

public class Musician extends Shorty implements IMusician {
    protected MusicalInstrument instrument = null;

    Musician(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public MusicalInstrument getMusicalInstrument() {
        return instrument;
    }

    @Override
    public void takeMusicalInstrument(MusicalInstrument instrument) {
        this.instrument = instrument;
        this.takeThing(instrument);
    }

    @Override
    public void playOn(MusicalInstrument instrument) {
        System.out.println(this + " plays on " + instrument);
        instrument.play();
    }
    @Override
    public void play() {
        playOn(this.instrument);
    }

    @Override
    public void hold(MusicalInstrument instrument) {
        System.out.println(this + " holds " + instrument);
        instrument.hold();
    }
    @Override
    public void hold() {
        hold(this.instrument);
    }
}
