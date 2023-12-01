package Lab3;

import Lab3.MusicalInstrument.BigHarp;
import Lab3.MusicalInstrument.HugeHarp;
import Lab3.MusicalInstrument.MiddleHarp;
import Lab3.MusicalInstrument.SmallHarp;

public class Scene {
    private Orchestra orchestra;
    private Shorty main_character;
    public void init() {
        Musician[] musicians = {
                new Musician(new SmallHarp()),
                new Musician(new SmallHarp()),
                new Musician(new SmallHarp()),
                new Musician(new SmallHarp()),
                new Musician(new SmallHarp()),
                new Musician(new MiddleHarp()),
                new Musician(new MiddleHarp()),
                new Musician(new MiddleHarp()),
                new Musician(new BigHarp()),
                new Musician(new HugeHarp())
        };

        Location.SECOND_FLOOR.setDecoration(Decoration.FLOWERS);
        for (var e : musicians) {
            e.setGender(Gender.FEMALE);
        }
        this.orchestra = new Orchestra(musicians);


        this.main_character = new Shorty("Гвоздик", Gender.MALE);
        main_character.setHairstyle(Hairstyle.PROTRUDING_TUFT);
        main_character.setAppearances(Appearance.COMBED, Appearance.WASHED);
        main_character.setClothing(Clothes.CLEAN_SHIRT);
    }

    public void main() {
        System.out.print(Location.SECOND_FLOOR.getDescription());
        System.out.print(", который украшен ");
        System.out.println(Location.SECOND_FLOOR.getDecoration().getDescription());
        System.out.println("Там находился оркестр из " + orchestra.getMusicians().toArray().length + " музыкантов");
        for (var e : orchestra.getMusicians()) {
            System.out.println(e.hold());
        }
        orchestra.play();

        System.out.println(TimeOfDay.EVENING.getDescription() +
                " еще не наступил, но все уже собрались на " +
                Location.PLATFORM.getDescription());
        System.out.println("Первым приехал " + main_character);
        main_character.setLocation(Location.PLATFORM);
        System.out.print("Он был в ");
        for (var e: main_character.getClothing()) {
            System.out.print(e.getDescription() + " ");
        }
        System.out.println();

        System.out.print("Он был ");
        for (var e: main_character.getAppearances()) {
            System.out.print(e.getDescription() + " ");
        }

        System.out.println("На голове у него был " + main_character.getHairstyle().getDescription());
    }
}
