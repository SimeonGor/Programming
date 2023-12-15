package Lab3;

import java.util.Random;

public abstract class Person {
    public enum Gender {
        MALE,
        FEMALE;
    }
    protected String name;
    protected Gender gender;

    public Person() {
        this("Unnamed", ((new Random()).nextBoolean() ? Gender.FEMALE : Gender.MALE));
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Person other = ((Person) o);
        return this.name.equals(other.getName()) && this.gender == other.gender;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode() << 1 + (this.gender == Gender.FEMALE ? 1 : 0);
    }
}
