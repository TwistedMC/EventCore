package net.twistedmc.events.util.api_annotations;

import java.lang.annotation.*;


@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
public @interface Unused {
/**
 * Use of this flag means the method inside {@code twistedmc.events.util.API} is not used, this may also mean
 * it is not tested either, so use at your own risk.
 */
}
