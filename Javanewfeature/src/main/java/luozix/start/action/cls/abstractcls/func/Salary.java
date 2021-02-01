/**
 * 
 */
package luozix.start.action.cls.abstractcls.func;

/**
 * @author xiaoy
 *
 */
/* 文件名 : Salary.java */
public class Salary extends Employee {
	private double salary; // Annual salary

	@Override
	public double computePay() {
		System.out.println("Computing salary pay for " + getName());
		return salary / 52;
	}

	/**
	 * @return
	 */
	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	// 其余代码
}
