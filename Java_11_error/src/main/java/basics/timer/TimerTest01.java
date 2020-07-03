/**
 *
 */
package basics.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Office
 *
 */
public class TimerTest01 {
    Timer timer;

    public TimerTest01(int time) {
	timer = new Timer();
	timer.schedule(new TimerTaskTest01(), time * 1000);
    }

    public static void main(String[] args) {
	System.out.println("timer begin....");
	new TimerTest01(3);
    }
}

class TimerTaskTest01 extends TimerTask {

    public void run() {
	System.out.println("Time's up!!!!");
    }
}
