package Lab3;

import Lab3.Location.Town;
import Lab3.Music.IMusician;
import Lab3.Thing.MusicalInstrument.MusicalInstrument;
import Lab3.Thing.StealingException;

public class Musician extends Shorty implements IMusician {
    private MusicalInstrument instrument = null;

    public Musician() {super();}

    public Musician(String name, Gender gender, Town nativeTown) {
        super(name, gender, nativeTown);
    }

    @Override
    public MusicalInstrument getMusicalInstrument() {
        return instrument;
    }

    @Override
    public void takeMusicalInstrument(MusicalInstrument instrument) throws StealingException {
        this.instrument = instrument;
        this.takeThing("musical instrument", instrument);
    }

    @Override
    public void playOn(MusicalInstrument instrument) {
        if (instrument != null) {
            System.out.println(this + " plays on " + instrument);
            instrument.play();
        }
    }
    @Override
    public void play() {
        playOn(this.instrument);
    }

    @Override
    public void hold(MusicalInstrument instrument) {
        if (instrument != null) {
            System.out.println(this + " holds " + instrument);
            instrument.hold();
        }
    }
    @Override
    public void hold() {
        hold(this.instrument);
    }
}
