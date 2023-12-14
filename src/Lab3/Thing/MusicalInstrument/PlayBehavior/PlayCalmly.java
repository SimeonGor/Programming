package Lab3.Thing.MusicalInstrument.PlayBehavior;

public class PlayCalmly implements PlayBehavior{
    @Override
    public void play() {
        System.out.println("The musical instrument is playing calmly");
    }

    @Override
    public String toString() {
        return "plays calmly";
    }
}
