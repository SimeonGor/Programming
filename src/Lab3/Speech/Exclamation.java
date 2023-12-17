package Lab3.Speech;

public class Exclamation extends SpeechDecorator {
    public Exclamation(Speech speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return (char)27 + "[1m" + speech.getSpeech() + "!" + (char)27 + "[0m";
    }
}
