

+ 创建型模式： 工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

+ 结构型模式： 适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

+ 行为型模式： 策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。








SELECT
			factor_war,
			warning_id
		FROM
			pes_warning_log_detail
		WHERE
			deptid = '517d16f720f7c6624cfb4245cc0586c0'
			


record Person(
    String firstName,
    String lastName,
    String address,
    LocalDate birthday,
    List<String> achievements) {
}



import ai.dynamind.dbproxy.shared.CloseUtil;
import ai.dynamind.dbproxy.shared.LangUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

@DisplayName("Stress JDBC Transactional Tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StressTests extends Base {

    private final static String[] FIRST_NAMES = new String[]{"John", "Ivan", "Rumen", "Hristo"};
    private final static String[] LAST_NAMES = new String[]{"Stoyanov", "Petrov", "Trump", "Biden", "McDonald"};
    private static final Random random = new Random();

    @Test
    @Order(1)
    @DisplayName("Open connection to proxy and create tables")
    void createTable() throws SQLException {

        System.out.println("Creating table(s)...");
        try (var statement = connection.createStatement()) {
            statement.execute(
                    """

                            drop table if exists stress_test;

                            create table stress_test(
                              client_id bigint,
                              first_name varchar(100),
                              last_name varchar(100)
                            );
                            """);
        }

        System.out.println("Creating table(s)...DONE");
    }

    @Test
    @Order(10)
    @DisplayName("run transactional inserts in threads")
    void transactionalInserts() throws SQLException {
        final var connections = new Connection[10];
        final var threads = new Thread[100];
        System.out.printf("About to run transactional INSERTs across %d connections in %d threads...", connections.length, threads.length);
        try {
            for (int i = 0; i < connections.length; i++) {
                // ds.setPacketSize(1000 + (i % 5) * 1000);
                connections[i] = DriverManager.getConnection(DBPROXY_URL);
                connections[i].setAutoCommit(false);
            }
            System.out.printf("Created %d connections\n", connections.length);
            for (int i = 0; i < threads.length; i++) {
                final int ii = i;
                threads[i] = new Thread(() -> {
                    final int connectionIndex = random.nextInt(connections.length);
                    var connection = connections[connectionIndex];
                    try (var statement = connection.prepareStatement("insert into stress_test(client_id, first_name, last_name) values(?,?,?)")) {
                        for (var firstName : FIRST_NAMES) {
                            for (var lastName : LAST_NAMES) {
                                int column = 1;
                                statement.setInt(column++, ii);
                                statement.setString(column++, firstName);
                                statement.setString(column++, lastName);
                                statement.addBatch();
                                //statement.execute();
                            }
                        }
                        statement.executeBatch();
                        connection.commit();
                    } catch (SQLException se) {
                        se.printStackTrace(System.err);
                        LangUtil.rethrowUnchecked(se);
                    }
                }, "Insert thread " + i);
                threads[i].start();
            }
            for (var thread : threads) thread.join();
            System.out.println("DONE!");
        } catch (InterruptedException se) {
            se.printStackTrace(System.err);
        } finally {
            CloseUtil.quietCloseAll(connections);
        }
    }
}			