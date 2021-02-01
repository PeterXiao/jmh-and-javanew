/**
 * 
 */
package luozix.start.action.cls;

public class Employee {
	// 这个实例变量对子类可见
	public String name;
	// 私有变量，仅在该类可见
	private double salary;

	// 在构造器中对name赋值
	public Employee(String empName) {
		name = empName;
	}

	// 设定salary的值
	public void setSalary(double empSal) {
		salary = empSal;
	}

	// 打印信息
	public void printEmp() {
		System.out.println("名字 : " + name);
		System.out.println("薪水 : " + salary);
	}

	// salary是静态的私有变量
	private static double salary1;
	// DEPARTMENT是一个常量
	public static final String DEPARTMENT = "开发人员";

	public static void main(String[] args) {
		Employee empOne = new Employee("RUNOOB");
		empOne.setSalary(1000.0);
		empOne.printEmp();

		salary1 = 10000;
		System.out.println(DEPARTMENT + "平均工资:" + salary1);
	}
}