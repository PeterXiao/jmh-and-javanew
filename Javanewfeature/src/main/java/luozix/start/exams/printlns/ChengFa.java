/**
 * 
 */
package luozix.start.exams.printlns;

/**
 * @author xiaoy
 *
 */
public class ChengFa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChengFa cf = new ChengFa();
		for (int f = 1; f <= 9; f++) {
			cf.chengshu(1, f);
			cf.xiangcheng();
		}
	}

	public int a;
	public int b;

	public ChengFa() {
	}

	public void chengshu(int aa, int bb) {
		a = aa;
		b = bb;
	}

	public void xiangcheng() {
		int c;
		c = 10 - b;
		for (int d = 1; d <= c; d++) {
			System.out.print(a + "*" + b + "=" + (a * b) + " ");
			if ((a * b) < 10) {
				System.out.print(" ");
			}
			a++;
			b++;
		}
		System.out.print("\n");
	}

}
