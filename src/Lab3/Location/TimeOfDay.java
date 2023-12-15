package Lab3.Location;

public class TimeOfDay {
    private final int hours, minutes;
    TimeOfDay(int hours, int minutes) {
        this.hours = hours % 24;
        this.minutes = minutes % 60;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        TimeOfDay other = (TimeOfDay) o;
        return this.minutes == other.minutes
                && this.hours == other.hours;
    }

    @Override
    public int hashCode() {
        return hours * 60 + minutes;
    }

    @Override
    public String toString() {
        return hours % 12 + ":" + minutes + (hours < 12 ? "am" : "pm");
    }
}
