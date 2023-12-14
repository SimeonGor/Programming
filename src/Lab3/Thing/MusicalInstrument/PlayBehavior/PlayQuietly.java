package Lab3.Thing.MusicalInstrument.PlayBehavior;

public class PlayQuietly implements PlayBehavior {
    @Override
    public void play() {
        System.out.println("The musical instrument is playing quietly");
    }

    @Override
    public String toString() {
        return "plays quietly";
    }
}
