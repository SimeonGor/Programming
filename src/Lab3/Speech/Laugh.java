package Lab3.Speech;

public class Laugh extends SpeechDecorator {
    public Laugh(Speech speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return (char)27 + "[38;5;214m" + speech.getSpeech() + (char)27 + "[0m";
    }
}
