/**
 *
 */
package basics.annotation.java8;

import java.lang.annotation.Repeatable;

/**
 * @author Office
 *
 */
@Repeatable(Authorities.class)
public @interface Authority {
    String role();
}
