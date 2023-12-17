package Lab3.Thing.MusicalInstrument.PlayBehavior;

public class PlayVeryLoud implements PlayBehavior {
    @Override
    public void play() {
        System.out.println("The musical instrument is playing very loud");
    }

    @Override
    public String toString() {
        return "is playing very loud";
    }
}
