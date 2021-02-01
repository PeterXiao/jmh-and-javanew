/**
 * 
 */
package luozix.start.action.sclass;

/**
 * @author xiaoy
 *
 */
public class VirtualDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Salary s = new Salary("员工 A", "北京", 3, 3600.00);
		Employee e = new Salary("员工 B", "上海", 2, 2400.00);
		System.out.println("使用 Salary 的引用调用 mailCheck -- ");
		s.mailCheck();
		System.out.println("\n使用 Employee 的引用调用 mailCheck--");
		e.mailCheck();
	}

}
