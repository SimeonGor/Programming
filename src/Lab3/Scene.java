package Lab3;

import Lab3.Location.Place;
import Lab3.Location.Plants;
import Lab3.Location.Town;
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
    private Shorty znayka, nexnayka, solomka, gvozdik, shurupchik, bublik;

    private Town greenTown, flowerTown, zmeevka;
    public void init() {
        greenTown = new Town("Green Town");
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

        Clothes cleanShirt = new Clean(new FormalWear(FormalWear.Type.SHIRT));
        try {
            gvozdik.setClothing("SHIRT", cleanShirt);
        }
        catch (StealingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gvozdik.getClothing());

        znayka = new Shorty("Знайка", Person.Gender.MALE, flowerTown);
        try {
            znayka.setClothing("SHIRT", cleanShirt);
        }
        catch (StealingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(znayka.getClothing());
    }

    public void start() {
//        System.out.println(orchestra);
//        orchestra.play();
//        gvozdik.goTo(square);

        Thing notebook = new Notebook(10);

        znayka.writeIn(notebook, "very important note");
        System.out.println(notebook);

        Place square = new Place("площадка", new Plants(Plants.Type.TREES));
        square.setTimeOfDay(new Place.TimeOfDay(16, 30));
        greenTown.addPlace(square);

        System.out.println(greenTown);
    }
}
