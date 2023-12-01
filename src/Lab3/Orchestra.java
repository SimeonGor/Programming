package Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Orchestra {
    private ArrayList<IMusician> musicians = new ArrayList<>();

    Orchestra() {}

    Orchestra(IMusician[] args) {
        musicians = new ArrayList<>();
        musicians.addAll(Arrays.asList(args));
    }

    public void play() {
        System.out.println("Играет оркестр");
        for (var e : musicians) {
            System.out.println("\t" + e.play());
        }
        System.out.println("-----------");
    }

    public ArrayList<IMusician> getMusicians() {
        return musicians;
    }

    public void setMusicians(IMusician ... musicians) {
        this.musicians.addAll(Arrays.asList(musicians));
    }

    public void addMusician(IMusician musician) {
        this.musicians.add(musician);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Orchestra other = (Orchestra) o;
        return musicians == other.getMusicians();
    }
}
