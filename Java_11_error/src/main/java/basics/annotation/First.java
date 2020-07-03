/**
 *
 */
package basics.annotation;

/**
 * @author Office
 *
 */
import org.springframework.stereotype.Service;

@Simulation
@Service
public class First {
    @Run(rate = 0.5)
    boolean run() {
	System.out.println("first");

	return true;
    }

    @Report
    void report() {
	System.out.println("report first");
    }
}
