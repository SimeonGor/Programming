package Lab3.Thing.MusicalInstrument.HoldBehavior;

public class HoldInHands implements HoldBehavior {
    @Override
    public void hold() {
        System.out.println("The musical instrument is in the hands");
    }

    @Override
    public String toString() {
        return "is held in the hands";
    }
}
