package Lab3;

import Lab3.Thing.MusicalInstrument.Harp;
import Lab3.Thing.MusicalInstrument.HoldBehavior.*;
import Lab3.Thing.MusicalInstrument.PlayBehavior.*;

public class SimpleHarpFactory implements HarpFactory {
    @Override
    public Harp createHarp(String type) {
        if (type.equals("little"))
            return new Harp(new PlayQuietly(), new HoldInHands());
        else if (type.equals("middle"))
            return new Harp(new PlayCalmly(), new HoldOnLap());
        else if (type.equals("big"))
            return new Harp(new PlayLoudly(), new HoldOnFloor());
        else if (type.equals("huge"))
            return new Harp(new PlayVeryLoud(), new HoldOnFloor());
        return null;
    }
}
