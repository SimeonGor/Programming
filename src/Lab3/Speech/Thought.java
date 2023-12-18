package Lab3.Speech;

public class Thought extends SpeechDecorator {
    public Thought(Speech speech) {
        this.speech = speech;
    }
    @Override
    public String getSpeech() {
        return "{ " + speech.getSpeech() + " }";
    }
}
