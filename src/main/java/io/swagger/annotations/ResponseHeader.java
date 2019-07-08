package io.swagger.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a header that can be provided as part of the response.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseHeader {
	 /**
     * Header's name.
     */
    String name() default "";

    /**
     * Long description of the response header.
     */
    String description() default "";

    /**
     * Header's data type.
     */
    Class<?> response() default Void.class;

    /**
     * Declares a container wrapping the response header.
     * <p>
     * Valid values are "List" or "Set". Any other value will be ignored.
     */
    String responseContainer() default "";
}
