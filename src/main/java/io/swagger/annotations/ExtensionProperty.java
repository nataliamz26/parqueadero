package io.swagger.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A name/value property within a Swagger extension
 *
 * @see Extension
 * @since 1.5.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtensionProperty {
	  /**
     * The name of the property.
     *
     * @return the name of the property
     */
    String name();

    /**
     * The value of the property.
     *
     * @return the value of the property
     */
    String value();
}
