package Lab3.MusicalInstrument;

public class HugeHarp extends Harp {
    @Override
    public String play() {
        return "climbs the ladder and plays the huge harp";
    }

    @Override
    public String hold() {
        return "holds a huge harp on the floor";
    }

    @Override
    public String toString() {
        return "Huge Harp";
    }
}
