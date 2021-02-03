/**
 * 
 */
package luozix.start.exams.exceptions;

/**
 * @author xiaoy
 *
 */
public class ThreadsExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyThread t = new MyThread();
	        t.start();
	        try{
	            Thread.sleep(1000);
	        }
	        catch (Exception x){
	            System.out.println("Caught it" + x);
	        }
	        System.out.println("Exiting main");
	    }


}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Throwing in " + "MyThread");
		throw new RuntimeException();
	}
}