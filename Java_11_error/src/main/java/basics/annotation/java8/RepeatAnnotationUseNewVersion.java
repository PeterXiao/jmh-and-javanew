/**
 *
 */
package basics.annotation.java8;

/**
 * @author Office
 *
 */
public class RepeatAnnotationUseNewVersion {
    @Authority(role = "Admin")
    @Authority(role = "Manager")
    public void doSomeThing() {
    }
}
