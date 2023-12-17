package Lab3.Speech;

public class BasicSpeech extends Speech {
    public BasicSpeech(String s) {
        this.sentence = s;
    }

    public String getSpeech() {
        return sentence;
    }
}
