/**
 * 
 */
package luozix.start.action.interfacesmd;

/**
 * @author xiaoy
 *
 */

//文件名: Hockey.java
public interface Hockey extends Sports {
	public void homeGoalScored();

	public void visitingGoalScored();

	public void endOfPeriod(int period);

	public void overtimePeriod(int ot);
}