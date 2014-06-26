package com.datastax.driver.mapping.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allows to specify the name of the CQL UDT field to which the
 * Java field should be mapped.
 * <p>
 * Note that this annotation is generally optional in the sense that any field
 * of a class annotated by {@link UDT} will be mapped by default to a UDT field
 * having the same name than this Java field unless that Java field has the
 * {@link Transient} annotation. As such, this annotation is mainly useful when
 * the name to map the field to is not the same one that the field itself (but
 * can be added without it's name parameter for documentation sake).
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    /**
     * Name of the column being mapped in Cassandra. By default, the name of the
     * field will be used.
     *
     * @return the name of the mapped column in Cassandra, or {@code ""} to use
     * the field name.
     */
    String name() default "";

    /**
     * Whether the column name is a case sensitive one.
     *
     * @return whether the column name is a case sensitive one.
     */
    boolean caseSensitive() default false;
}
