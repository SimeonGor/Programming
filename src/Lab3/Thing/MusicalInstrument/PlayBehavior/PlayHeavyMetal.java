package Lab3.Thing.MusicalInstrument.PlayBehavior;

public class PlayHeavyMetal implements PlayBehavior {
    @Override
    public void play() {
        System.out.println("The musical instrument is playing heavy metal");
    }

    @Override
    public String toString() {
        return "is playing heavy metal";
    }
}
