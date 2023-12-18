package Lab3;

import Lab3.Location.Place;
import Lab3.Location.Plants;
import Lab3.Location.TimeOfDay;
import Lab3.Speech.*;
import Lab3.Thing.Clothes.*;
import Lab3.Music.Orchestra;

import java.util.List;
import java.util.Vector;

public class Scene {
    private Orchestra orchestra;
    private Shorty main_character;
    public void init() {
        HarpFactory harpFactory = new SimpleHarpFactory();
        List<Musician> musicianList = new Vector<>();
        for (int i = 0; i < 5; i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE);
            t.takeMusicalInstrument(harpFactory.createHarp("little"));
            musicianList.add(t);
        }
        for (int i = 0; i < 3; i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE);
            t.takeMusicalInstrument(harpFactory.createHarp("middle"));
            musicianList.add(t);
        }
        for (int i = 0; i < 1; i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE);
            t.takeMusicalInstrument(harpFactory.createHarp("big"));
            musicianList.add(t);
        }
        for (int i = 0; i < 1; i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE);
            t.takeMusicalInstrument(harpFactory.createHarp("huge"));
            musicianList.add(t);
        }
        orchestra = new Orchestra(musicianList.toArray(new Musician[0]));

        main_character = new Shorty("Гвоздик", Person.Gender.MALE);
        main_character.doHairstyle(Hairstyle.PROTRUDING_TUFT);
        main_character.changeClothing(new Clean(new FormalWear(FormalWear.Type.SHIRT)));
    }

    public void start() {
        System.out.println(orchestra);
        orchestra.play();
        Place square = new Place("площадка", new Plants(Plants.Type.TREES));
        square.setTimeOfDay(new TimeOfDay(16, 30));

        main_character.goTo(square);
        main_character.speak(new Laugh(new BasicSpeech("Hi")));
    }
}
