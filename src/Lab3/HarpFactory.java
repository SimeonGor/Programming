package Lab3;

import Lab3.Thing.MusicalInstrument.Harp;
import Lab3.Thing.MusicalInstrument.HoldBehavior.*;
import Lab3.Thing.MusicalInstrument.PlayBehavior.*;

public class HarpFactory {
    public enum Type {
        LITTLE,
        MIDDLE,
        BIG,
        HUGE;
    }

    public Harp createHarp(Type type) {
        if (type == Type.LITTLE)
            return new Harp(new PlayQuietly(), new HoldInHands());
        else if (type == Type.MIDDLE)
            return new Harp(new PlayCalmly(), new HoldOnLap());
        else if (type == Type.BIG)
            return new Harp(new PlayLoudly(), new HoldOnFloor());
        else if (type == Type.HUGE)
            return new Harp(new PlayVeryLoud(), new HoldOnFloor());
        return null;
    }
}
