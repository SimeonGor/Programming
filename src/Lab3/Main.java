package Lab3;

import Lab3.Thing.StealingException;

public class Main {
    public static void main (String[] args) throws StealingException {
        Scene scene = new Scene();
        scene.init();
        scene.start();
    }
}
