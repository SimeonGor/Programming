package Lab3.Music;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Orchestra {
    private List<IMusician> musicians = new Vector<>();

    Orchestra() {}

    Orchestra(IMusician ... args) {
        musicians.addAll(Arrays.asList(args));
    }

    public void play() {
        System.out.println("Играет оркестр");
        for (var e : musicians) {
            e.hold();
            e.play();
        }
        System.out.println("--------");
    }

    public List<IMusician> getMusicians() {
        return musicians;
    }

    public void setMusicians(IMusician ... musicians) {
        this.musicians.clear();
        this.musicians.addAll(Arrays.asList(musicians));
    }

    public void addMusician(IMusician ... musicians) {
        this.musicians.addAll(Arrays.asList(musicians));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Orchestra other = (Orchestra) o;
        return musicians == other.getMusicians();
    }

    @Override
    public int hashCode() {
        return this.musicians.hashCode();
    }

    @Override
    public String toString() {
        return "Orchestra " + this.musicians.size();
    }
}
