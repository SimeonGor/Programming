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
import Lab3.Thing.MusicalInstrument.MusicalInstrument;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayCalmly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayLoudly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayQuietly;
import Lab3.Thing.MusicalInstrument.PlayBehavior.PlayVeryLoud;
import Lab3.Thing.Notebook;
import Lab3.Thing.StealingException;
import Lab3.Thing.Thing;

import java.util.*;

public class Scene {
    private Orchestra orchestra;
    private List<Shorty> malyshi, malyshki;
    private List<Shorty> residentsOfZmeevka;
    private Shorty znayka, neznayka, solomka, gvozdik, shurupchik, bublik;

    private Town greenTown, flowerTown, zmeevka;
    public void init() {
        interface ShortyFactory {
            Shorty createShorty();
        }

        class SimpleMusicianFactory implements ShortyFactory {
            private String name;
            private Person.Gender gender;
            private Town nativeTown;
            private MusicalInstrument musicalInstrument;

            public SimpleMusicianFactory(String name, Person.Gender gender, Town nativeTown, MusicalInstrument musicalInstrument) {
                this.name = name;
                this.gender = gender;
                this.nativeTown = nativeTown;
                this.musicalInstrument = musicalInstrument;
            }


            @Override
            public Musician createShorty() {
                Musician musician = new Musician("Unnamed", Person.Gender.FEMALE, greenTown);
                try {
                    musician.takeMusicalInstrument(musicalInstrument);
                }
                catch (StealingException e) {
                    System.out.println(e.getMessage());
                }

                return musician;
            }
        }
        class SimpleShortyFactory implements ShortyFactory {
            private String name;
            private Person.Gender gender;
            private Hairstyle hairstyle;
            private Town nativeTown;
            private Map<String, Clothes> clothes;
            private Map<String, Thing> thing;
            public SimpleShortyFactory(String name,
                                       Person.Gender gender,
                                       Town nativeTown, Hairstyle hairstyle,
                                       Map<String, Clothes> clothes, Map<String, Thing> thing) {
                this.name = name;
                this.gender = gender;
                this.nativeTown = nativeTown;
                this.hairstyle = hairstyle;
                this.clothes = clothes;
                this.thing = thing;
            }
            @Override
            public Shorty createShorty() {
                Shorty shorty = new Shorty(name, gender, nativeTown);
                shorty.setHairstyle(hairstyle);
                if (clothes != null) {
                    for (var e : clothes.entrySet()) {
                        try {
                            shorty.setClothing(e.getKey(), e.getValue());
                        } catch (StealingException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }

                if (thing != null) {
                    for (var e : thing.entrySet()) {
                        try {
                            shorty.takeThing(e.getKey(), e.getValue());
                        } catch (StealingException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }

                return shorty;
            }

        }
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
            musicianList.add((new SimpleMusicianFactory("Unnamed",
                    Person.Gender.FEMALE,
                    greenTown,
                    harpFactory.createHarp(typesOfHarps.get(i)))).createShorty());
        }
        orchestra = new Orchestra(musicianList.toArray(new Musician[0]));

        Map<String, Clothes> znaykaClothes = new HashMap<String, Clothes>();
        znaykaClothes.put("SUIT", new Ironed(new FormalWear(FormalWear.Type.SUIT)));
        Map<String, Thing> znaykaThings = new HashMap<>();
        znaykaThings.put("notebook", new Notebook(10));

        znayka = (new SimpleShortyFactory("Знайка",
                Person.Gender.MALE,
                flowerTown,
                Hairstyle.OTHER,
                znaykaClothes,
                znaykaThings)).createShorty();

        Map<String, Clothes> gvozdikClothes = new HashMap<>();
        gvozdikClothes.put("SHIRT", new Clean(new FormalWear(FormalWear.Type.SHIRT)));

        gvozdik = (new SimpleShortyFactory("Гвоздик",
                Person.Gender.MALE,
                zmeevka,
                Hairstyle.PROTRUDING_TUFT,
                gvozdikClothes,
                null)).createShorty();

        Map<String, Clothes> solomkaClothes = new HashMap<>();
        solomka = (new SimpleShortyFactory("Соломка",
                Person.Gender.FEMALE,
                greenTown,
                Hairstyle.PIGTAIL,
                solomkaClothes,
                null)).createShorty();

        Map<String, Clothes> neznaykaClothes = new HashMap<>();
        neznaykaClothes.put("SHIRT", new Wrinkled(new FormalWear(FormalWear.Type.SHIRT)));
        neznayka = (new SimpleShortyFactory("Незнайка",
                Person.Gender.MALE,
                flowerTown,
                Hairstyle.MESSY,
                neznaykaClothes,
                null)).createShorty();

        malyshki = new Vector<>();
        for (int i = 0; i < 5; i++) {
            malyshki.add((new SimpleShortyFactory(
                    "Unnamed" + i,
                    Person.Gender.FEMALE,
                    greenTown,
                    Hairstyle.PIGTAIL,
                    null,
                    null)).createShorty());
        }
        malyshi = new Vector<>();
        for (int i = 0; i < 5; i++) {
            malyshi.add((new SimpleShortyFactory(
                    "Unnamed" + i,
                    Person.Gender.MALE,
                    greenTown,
                    Hairstyle.OTHER,
                    null,
                    null)).createShorty());
        }


        shurupchik = (new SimpleShortyFactory("Шурупчик",
                Person.Gender.MALE,
                zmeevka,
                Hairstyle.SHORT,
                null,
                null)).createShorty();

        bublik = (new SimpleShortyFactory("Бублик",
                Person.Gender.MALE,
                zmeevka,
                Hairstyle.MESSY,
                null,
                null)).createShorty();

        residentsOfZmeevka = new Vector<>();
        for (int i = 0; i < 10; i++) {
            residentsOfZmeevka.add((new SimpleShortyFactory("Unnamed" + i,
                    (i % 2 == 0) ? Person.Gender.MALE : Person.Gender.FEMALE,
                    zmeevka,
                    Hairstyle.OTHER,
                    null,
                    null)).createShorty());
        }


        System.out.println("\n\n\n\n");
    }

    public void start() {
        System.out.println("\t\tMain Scene\n\n");
        znayka.goTo(greenTown.getPlaces().get("field"));
        Speech storyOfSolomka = new BasicSpeech("Story of " + solomka);
        for (var e: malyshki) {
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
