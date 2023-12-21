package Lab3.Thing.MusicalInstrument;

import Lab3.Thing.MusicalInstrument.HoldBehavior.HoldBehavior;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayBehavior;
import Lab3.Thing.Thing;

public class Harp extends Thing implements MusicalInstrument {
    private PlayBehavior playBehavior;
    private HoldBehavior holdBehavior;


    public Harp(PlayBehavior playBehavior, HoldBehavior holdBehavior) {
        this.playBehavior = playBehavior;
        this.holdBehavior = holdBehavior;
    }

    @Override
    public void play() {
        playBehavior.play();
    }

    @Override
    public void hold() {
        holdBehavior.hold();
    }

    @Override
    public void interact() {
        this.hold();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Harp other = (Harp) o;
        return (playBehavior.getClass() == other.playBehavior.getClass()) &&
                (holdBehavior.getClass() == other.holdBehavior.getClass());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "The harp that " + holdBehavior.toString() + " and " + playBehavior.toString();
    }
}
