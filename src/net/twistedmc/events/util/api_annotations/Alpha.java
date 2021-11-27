package net.twistedmc.events.util.api_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Alpha {
    /**
     * Use of this flag means the method inside {@code twistedmc.events.util.API} is currently being tested and worked on.
     *
     */
}
