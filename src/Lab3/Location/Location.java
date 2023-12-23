package Lab3.Location;

public abstract class Location {
    public class TimeOfDay {
        private int hours;
        private int minutes;
        public TimeOfDay(int hours, int minutes) {
            this.hours = hours % 24;
            this.minutes = minutes % 60;
        }

        public void setTime(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
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
    protected TimeOfDay timeOfDay = new TimeOfDay(0, 0);

    protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Location other = (Location) o;
        return other.getDescription().equals(this.getDescription());
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
