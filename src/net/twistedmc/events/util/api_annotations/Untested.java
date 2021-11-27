package net.twistedmc.events.util.api_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Untested {
    /**
     * Use of this flag means the method inside {@code twistedmc.events.util.API} has not been tested.
     * Which also means it should be tested in a developer server.
     */
}
