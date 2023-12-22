package Lab3;

import Lab3.Thing.Thing;

public class InvalidThingInterfaceException extends ClassCastException {
    private Thing thing;
    private String implementsInterface;
    public InvalidThingInterfaceException(Thing thing, String implementsInterface) {
        this.thing = thing;
        this.implementsInterface = implementsInterface;
    }

    @Override
    public String getMessage() {
        return thing + " cannot be used as " + implementsInterface;
    }
}
