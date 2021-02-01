/**
 * 
 */
package luozix.start.action.exs;

/**
 * @author xiaoy
 *
 */

class FreshJuice{
	enum FreshJuiceSize{SMALL, MEDIUM, LARGE}
	FreshJuiceSize size;
}
public class FreshJuiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      FreshJuice juice = new FreshJuice();
	      juice.size = FreshJuice.FreshJuiceSize.MEDIUM  ;
	}

}
