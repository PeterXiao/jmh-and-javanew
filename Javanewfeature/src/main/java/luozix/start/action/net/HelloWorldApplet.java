/**
 * 
 */
package luozix.start.action.net;

/**
 * @author xiaoy
 *
 */
import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorldApplet extends Applet {
	@Override
	public void paint(Graphics g) {
		g.drawString("Hello World", 25, 50);
	}
}
