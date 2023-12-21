package Lab3;

import Lab3.Location.Place;
import Lab3.Location.Plants;
import Lab3.Thing.Clothes.*;
import Lab3.Music.Orchestra;
import Lab3.Thing.StealingException;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Scene {
    private Orchestra orchestra;
    private Shorty main_character;
    public void init() {
        HarpFactory harpFactory = new SimpleHarpFactory();
        List<Musician> musicianList = new Vector<>();
        List<String> typesOfHarps = new Vector<>(List.of(
                new String[]{"little", "little", "middle", "middle", "big", "huge"}
        ));
        for (int i = 0; i < typesOfHarps.size(); i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE);
            try {
                t.takeMusicalInstrument(harpFactory.createHarp("little"));
            } catch (StealingException e) {
                System.out.println(e.getMessage());
            }

            musicianList.add(t);
        }
        orchestra = new Orchestra(musicianList.toArray(new Musician[0]));

        main_character = new Shorty("Гвоздик", Person.Gender.MALE);
        main_character.setHairstyle(Hairstyle.PROTRUDING_TUFT);
        try {
            main_character.setClothing(new Clean(new FormalWear(FormalWear.Type.SHIRT)));
        }
        catch (StealingException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        System.out.println(orchestra);
        orchestra.play();
        Place square = new Place("площадка", new Plants(Plants.Type.TREES));
        square.setTimeOfDay(new Place.TimeOfDay(16, 30));

        main_character.goTo(square);
    }
}
