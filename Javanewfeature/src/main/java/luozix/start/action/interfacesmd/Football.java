/**
 * 
 */
package luozix.start.action.interfacesmd;

/**
 * @author xiaoy
 *
 */
//文件名: Football.java
public interface Football extends Sports {
	public void homeTeamScored(int points);

	public void visitingTeamScored(int points);

	public void endOfQuarter(int quarter);
}
