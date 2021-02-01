/**
 * 
 */
package luozix.start.java9.j8;

/**
 * @author xiaoy
 *
 */
public class Testerj8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			LogOracle log = new LogOracle();
			log.logInfo("");
			log.logWarn("");
			log.logError("");
			log.logFatal("");

			LogMySql log1 = new LogMySql();
			log1.logInfo("");
			log1.logWarn("");
			log1.logError("");
			log1.logFatal("");
		}
	}

	final class LogOracle implements Logging {
	}

	final class LogMySql implements Logging {
	}

	interface Logging {
		String ORACLE = "Oracle_Database";
		String MYSQL = "MySql_Database";

		default void logInfo(String message) {
			getConnection();
			System.out.println("Log Message : " + "INFO");
			closeConnection();
		}

		default void logWarn(String message) {
			getConnection();
			System.out.println("Log Message : " + "WARN");
			closeConnection();
		}

		default void logError(String message) {
			getConnection();
			System.out.println("Log Message : " + "ERROR");
			closeConnection();
		}

		default void logFatal(String message) {
			getConnection();
			System.out.println("Log Message : " + "FATAL");
			closeConnection();
		}

		static void getConnection() {
			System.out.println("Open Database connection");
		}

		static void closeConnection() {
			System.out.println("Close Database connection");
		}
	}