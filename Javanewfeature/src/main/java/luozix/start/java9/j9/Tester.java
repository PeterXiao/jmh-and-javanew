/**
 * 
 */
package luozix.start.java9.j9;

/**
 * @author xiaoy
 *
 */
public class Tester {
	public static void main(String[] args) {
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

	private void log(String message, String prefix) {
		getConnection();
		System.out.println("Log Message : " + prefix);
		closeConnection();
	}

	default void logInfo(String message) {
		log(message, "INFO");
	}

	default void logWarn(String message) {
		log(message, "WARN");
	}

	default void logError(String message) {
		log(message, "ERROR");
	}

	default void logFatal(String message) {
		log(message, "FATAL");
	}

	private static void getConnection() {
		System.out.println("Open Database connection");
	}

	private static void closeConnection() {
		System.out.println("Close Database connection");
	}
}