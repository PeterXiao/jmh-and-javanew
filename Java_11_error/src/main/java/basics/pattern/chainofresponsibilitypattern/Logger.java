/**
 *
 */
package basics.pattern.chainofresponsibilitypattern;

/**
 * @author Office
 *
 */

abstract class Logger {
	public static int ERR = 3;
	public static int NOTICE = 5;
	public static int DEBUG = 7;
	protected int mask;

	// The next element in the chain of responsibility
	protected Logger next;

	public Logger setNext(Logger l) {
		next = l;
		return this;
	}

	public final void message(String msg, int priority) {
		if (priority <= mask) {
			writeMessage(msg);
			if (next != null) {
				next.message(msg, priority);
			}
		}
	}

	protected abstract void writeMessage(String msg);

}

class StdoutLogger extends Logger {

	public StdoutLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Writting to stdout: " + msg);
	}
}

class EmailLogger extends Logger {

	public EmailLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Sending via email: " + msg);
	}
}

class StderrLogger extends Logger {

	public StderrLogger(int mask) {
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg) {
		System.out.println("Sending to stderr: " + msg);
	}
}
