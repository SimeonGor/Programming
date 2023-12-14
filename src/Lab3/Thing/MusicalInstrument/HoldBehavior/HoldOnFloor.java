package Lab3.Thing.MusicalInstrument.HoldBehavior;

public class HoldOnFloor implements HoldBehavior {
    @Override
    public void hold() {
        System.out.println("The musical instrument is on the floor");
    }

    @Override
    public String toString() {
        return "holds on floor";
    }
}
