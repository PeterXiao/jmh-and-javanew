/**
 * 
 */
package luozix.start.action.concurrent.threads.exam;

/**
 * @author xiaoy
 *
 */
//文件名 : GuessANumber.java
//通过继承 Thread 类创建线程

public class GuessANumber extends Thread {
	private int number;

	public GuessANumber(int number) {
		this.number = number;
	}

@Override
public void run() {
   int counter = 0;
   int guess = 0;
   do {
      guess = (int) (Math.random() * 100 + 1);
      System.out.println(this.getName() + " guesses " + guess);
      counter++;
   } while(guess != number);
   System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
}
}
