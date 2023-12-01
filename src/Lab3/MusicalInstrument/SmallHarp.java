package Lab3.MusicalInstrument;

public class SmallHarp extends Harp {
    @Override
    public String play() {
        return "plays on the small harp";
    }

    @Override
    public String hold() {
        return "holds a small harp in his/her hands";
    }

    @Override
    public String toString() {
        return "Small Harp";
    }
}
