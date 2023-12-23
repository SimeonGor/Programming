package Lab3;

import Lab3.Thing.Thing;

public class InvalidThingInterfaceException extends ClassCastException {
    private final Object thing;
    private final String implementsInterface;
    public InvalidThingInterfaceException(Object thing, String implementsInterface) {
        super(thing + " cannot be used as " + implementsInterface);
        this.thing = thing;
        this.implementsInterface = implementsInterface;
    }

    public Object getThing() {
        return thing;
    }

    public String getImplementsInterface() {
        return implementsInterface;
    }
}
