/**
 * 
 */
package luozix.start.java9;



/**
 * @author xiaoy
 *
 */
public class Testerj7 {
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
	@Override
	public void logInfo(String message) {
		getConnection();
		System.out.println("Log Message : " + "INFO");
		closeConnection();
	}

	@Override
	public void logWarn(String message) {
		getConnection();
		System.out.println("Log Message : " + "WARN");
		closeConnection();
	}

	@Override
	public void logError(String message) {
		getConnection();
		System.out.println("Log Message : " + "ERROR");
		closeConnection();
	}

	@Override
	public void logFatal(String message) {
		getConnection();
		System.out.println("Log Message : " + "FATAL");
		closeConnection();
	}

	@Override
	public void getConnection() {
		System.out.println("Open Database connection");
	}

	@Override
	public void closeConnection() {
		System.out.println("Close Database connection");
	}
}

final class LogMySql implements Logging {
	@Override
	public void logInfo(String message) {
		getConnection();
		System.out.println("Log Message : " + "INFO");
		closeConnection();
	}

	@Override
	public void logWarn(String message) {
		getConnection();
		System.out.println("Log Message : " + "WARN");
		closeConnection();
	}

	@Override
	public void logError(String message) {
		getConnection();
		System.out.println("Log Message : " + "ERROR");
		closeConnection();
	}

	@Override
	public void logFatal(String message) {
		getConnection();
		System.out.println("Log Message : " + "FATAL");
		closeConnection();
	}

	@Override
	public void getConnection() {
		System.out.println("Open Database connection");
	}

	@Override
	public void closeConnection() {
		System.out.println("Close Database connection");
	}
}

interface Logging {
	String ORACLE = "Oracle_Database";
	String MYSQL = "MySql_Database";

	void logInfo(String message);

	void logWarn(String message);

	void logError(String message);

	void logFatal(String message);

	void getConnection();

	void closeConnection();
}
