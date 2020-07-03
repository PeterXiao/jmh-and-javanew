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

/**
 * Created by sigh on 2015/6/10.
 */
//类似junit的@Test效果
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Run {
    // 该操作发生的概率
    double rate() default 0;
}

