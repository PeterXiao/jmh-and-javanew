/**
 *
 */
package basics.annotation;

/**
 * @author Office
 *
 */



public class RepeatAnnotationUseOldVersion {

    @Authorities({ @Authority(role = "Admin"), @Authority(role = "Manager") })
    public void doSomeThing() {
    }
}