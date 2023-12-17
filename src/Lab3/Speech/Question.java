package Lab3.Speech;

public class Question extends SpeechDecorator {
    public Question(Speech speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return (char)27 + "[4m" + speech.getSpeech()  + "?" + (char)27 + "[0m";
    }
}
