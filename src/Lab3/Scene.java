package Lab3;

import Lab3.Location.*;
import Lab3.Speech.*;
import Lab3.Thing.Clothes.*;
import Lab3.Music.Orchestra;
import Lab3.Thing.Food.*;
import Lab3.Thing.MusicalInstrument.Harp;
import Lab3.Thing.MusicalInstrument.HoldBehavior.HoldInHands;
import Lab3.Thing.MusicalInstrument.HoldBehavior.HoldOnFloor;
import Lab3.Thing.MusicalInstrument.HoldBehavior.HoldOnLap;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayCalmly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayLoudly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayQuietly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayVeryLoud;
import Lab3.Thing.Notebook;
import Lab3.Thing.StealingException;
import Lab3.Thing.Thing;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Scene {
    private Orchestra orchestra;
    private List<Shorty> malyshi;
    private List<Shorty> residentsOfZmeevka;
    private Shorty znayka, neznayka, solomka, gvozdik, shurupchik, bublik;

    private Town greenTown, flowerTown, zmeevka;
    public void init() {
        greenTown = new Town("Green Town");
        Place square = new Place("площадка", new Plants(Plants.Type.TREES));
        Place dandelionThickets = new Place("заросли одуванчиков", new Plants(Plants.Type.FLOWERS));
        Place field = new Place("поле с арбузами");
        greenTown.addPlace("square", square);
        greenTown.addPlace("thickets", dandelionThickets);
        greenTown.addPlace("field", field);

        flowerTown = new Town("Flower Town");
        zmeevka = new Town("Zmeevka");
        HarpFactory harpFactory = new HarpFactory() {
            @Override
            public Harp createHarp(String type) {
                return switch (type) {
                    case "little" -> new Harp(new PlayQuietly(), new HoldInHands());
                    case "middle" -> new Harp(new PlayCalmly(), new HoldOnLap());
                    case "big" -> new Harp(new PlayLoudly(), new HoldOnFloor());
                    case "huge" -> new Harp(new PlayVeryLoud(), new HoldOnFloor());
                    default -> null;
                };
            }
        };

        List<Musician> musicianList = new Vector<>();
        List<String> typesOfHarps = new Vector<>(List.of(
                new String[]{"little", "little", "middle", "middle", "big", "huge"}
        ));
        for (int i = 0; i < typesOfHarps.size(); i++) {
            Musician t = new Musician("Unnamed", Person.Gender.FEMALE, greenTown);
            t.takeMusicalInstrument(harpFactory.createHarp("little"));
            musicianList.add(t);
        }
        orchestra = new Orchestra(musicianList.toArray(new Musician[0]));

        gvozdik = new Shorty("Гвоздик", Person.Gender.MALE, zmeevka);
        gvozdik.setHairstyle(Hairstyle.PROTRUDING_TUFT);
        try {
            gvozdik.setClothing("SHIRT", new Clean(new FormalWear(FormalWear.Type.SHIRT)));
        }
        catch (StealingException e) {
            System.out.println(e.getMessage());
        }

        znayka = new Shorty("Знайка", Person.Gender.MALE, flowerTown);
        znayka.setClothing("SUIT", new Ironed(new FormalWear(FormalWear.Type.SUIT)));
        znayka.takeThing("notebook", new Notebook(10));

        solomka = new Shorty("Соломка", Person.Gender.FEMALE, greenTown);
        solomka.setClothing("dress", new Clean(new WomenClothing(WomenClothing.Type.DRESS)));

        neznayka = new Shorty("Незнайка", Person.Gender.MALE, flowerTown);
        neznayka.setClothing("SHIRT", new Wrinkled(new FormalWear(FormalWear.Type.SHIRT)));

        malyshi = new Vector<>();
        for (int i = 0; i < 5; i++) {
            malyshi.add(new Shorty("Unnamed" + i, Person.Gender.FEMALE, greenTown));
        }
    }

    public void start() {
//        System.out.println(orchestra);
//        orchestra.play();
//        gvozdik.goTo(square);
        znayka.goTo(greenTown.getPlaces().get("field"));
        Speech storyOfSolomka = new BasicSpeech("Story of " + solomka);
        for (var e: malyshi) {
            e.speak(storyOfSolomka);
        }

        solomka.goTo(greenTown.getPlaces().get("field"));

        znayka.speak(new Question(new BasicSpeech("How to grow watermelons")));
        znayka.writeIn(znayka.getThings().get("notebook"),
                solomka.speak(new BasicSpeech("fruit growing methods")).getSpeech());
        System.out.println(znayka.getThings());


        for (int i = 0; i < 3; ++i) {
            neznayka.goTo(greenTown.getPlaces().get("thickets"));
            neznayka.goTo(greenTown.getPlaces().get("field"));
            neznayka.speak(new Thought(new Exclamation(new BasicSpeech("Нет, видно, еще не забыли!"))));
        }

        greenTown.getPlaces().get("square").addDecorations(new Tent("нарядные палатки"));
        greenTown.getPlaces().get("square").addDecorations(new Ropes(Ropes.Type.FLAGS));
        greenTown.getPlaces().get("square").addDecorations(new Ropes(Ropes.Type.LANTERNS));
        System.out.println(greenTown);
    }
}
