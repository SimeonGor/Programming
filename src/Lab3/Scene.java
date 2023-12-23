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
            try {
                t.takeMusicalInstrument(harpFactory.createHarp("little"));
            }
            catch (StealingException e) {
                System.out.println(e.getMessage());
            }
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
        try {
            znayka.setClothing("SUIT", new Ironed(new FormalWear(FormalWear.Type.SUIT)));
        } catch (StealingException e) {
            System.out.println(e.getMessage());
        }
        try {
            znayka.takeThing("notebook", new Notebook(10));
        } catch (StealingException e) {
            System.out.println(e.getMessage());
        }

        solomka = new Shorty("Соломка", Person.Gender.FEMALE, greenTown);
        try {
            solomka.setClothing("dress", new Clean(new WomenClothing(WomenClothing.Type.DRESS)));
        } catch (StealingException e) {
            System.out.println(e.getMessage());
        }

        neznayka = new Shorty("Незнайка", Person.Gender.MALE, flowerTown);
        try {
            neznayka.setClothing("SHIRT", new Wrinkled(new FormalWear(FormalWear.Type.SHIRT)));
        } catch (StealingException e) {
            System.out.println(e.getMessage());
        }

        malyshi = new Vector<>();
        for (int i = 0; i < 5; i++) {
            malyshi.add(new Shorty("Unnamed" + i, Person.Gender.FEMALE, greenTown));
        }

        shurupchik = new Shorty("Шурупчик", Person.Gender.MALE, zmeevka);
        bublik = new Shorty("Бублик", Person.Gender.MALE, zmeevka);

        residentsOfZmeevka = new Vector<>();
        for (int i = 0; i < 10; i++) {
            residentsOfZmeevka.add(new Shorty("Unnamed" + i,
                    (i % 2 == 0) ? Person.Gender.MALE : Person.Gender.FEMALE,
                    zmeevka));
        }
    }

    public void start() {
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
        neznayka.goTo(greenTown.getPlaces().get("thickets"));

        greenTown.getPlaces().get("square").addDecorations(new Tent("нарядные палатки"));
        greenTown.getPlaces().get("square").addDecorations(new Ropes(Ropes.Type.FLAGS));
        greenTown.getPlaces().get("square").addDecorations(new Ropes(Ropes.Type.LANTERNS));
        System.out.println(greenTown);

        greenTown.getPlaces().get("square").setTimeOfDay(new Place.TimeOfDay(16, 30));
        orchestra.play();

        gvozdik.goTo(greenTown.getPlaces().get("square"));
        bublik.goTo(greenTown.getPlaces().get("square"));

        for (var e : residentsOfZmeevka) {
            e.goTo(greenTown.getPlaces().get("square"));
            e.speak(new BasicSpeech("Thanks for the fruits"));
        }

        neznayka.sleep("a long time");
        neznayka.goTo(greenTown.getPlaces().get("square"));
        for (var e : malyshi) {
            e.speak(new Laugh(new Exclamation(new BasicSpeech("something offensive"))));
        }

        Fence fence = new Fence("забор");
        (new Writer(){}).writeIn(fence, "Незнайка дурак");
        neznayka.goTo(new Place("куда глаза глядят", fence));

        neznayka.takeDamage(new Hit(10, fence));
        neznayka.eat(new BasicFood("apple", 49, BasicFood.Type.FRUIT));
    }
}
