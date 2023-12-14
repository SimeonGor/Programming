package Lab3.Thing.MusicalInstrument.PlayBehavior;

public class PlayLoudly implements PlayBehavior {
    @Override
    public void play() {
        System.out.println("The musical instrument is playing loudly");
    }

    @Override
    public String toString() {
        return "plays loudly";
    }
}
