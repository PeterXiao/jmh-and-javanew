/**
 * 
 */
package luozix.start.java14;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaoy
 *
 */
/**
 * Now the is a new location for annotation.
 *
 * Behavior depends on type: - RECORD_COMPONENT: will be replicated to field,
 * constructor and accessor method - METHOD: will be replicated only to the
 * accessor method - FIELD: will be replicated only to the field declaration -
 * CONSTRUCTOR: will be replicated only to the constructor
 */
@Target(ElementType.RECORD_COMPONENT)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validatable {
	boolean validate();
}
