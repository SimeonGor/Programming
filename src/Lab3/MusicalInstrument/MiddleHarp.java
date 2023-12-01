package Lab3.MusicalInstrument;

public class MiddleHarp extends Harp {
    @Override
    public String play() {
        return "plays the middle harp";
    }

    @Override
    public String hold() {
        return "holds a middle harp in his/her lap";
    }

    @Override
    public String toString() {
        return "Middle Harp";
    }
}
