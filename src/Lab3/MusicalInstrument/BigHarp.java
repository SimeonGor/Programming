package Lab3.MusicalInstrument;

public class BigHarp extends Harp {
    @Override
    public String play() {
        return "plays the big harp";
    }

    @Override
    public String hold() {
        return "holds a big harp on the floor";
    }

    @Override
    public String toString() {
        return "Big Harp";
    }
}
