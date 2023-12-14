package Lab3.Thing.MusicalInstrument.HoldBehavior;

public class HoldOnLap implements HoldBehavior {
    @Override
    public void hold() {
        System.out.println("The musical instrument is on the lap");
    }

    @Override
    public String toString() {
        return "holds on lap";
    }
}
