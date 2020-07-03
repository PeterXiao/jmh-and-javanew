/**
 *
 */
package basics.annotation;

/**
 * @author Office
 *
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//在所有@Run运行完之后报告结果
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Report {
}

