/**
 *
 */
package basics.annotation;

import org.springframework.stereotype.Service;

/**
 * @author Office
 *
 */
@Simulation
@Service
public class Second {
    @Run(rate = 0.5)
    long doWork() {
	System.out.println("second");

	return 3;
    }

    @Report
    void display() {
	System.out.println("display second");
    }
}

