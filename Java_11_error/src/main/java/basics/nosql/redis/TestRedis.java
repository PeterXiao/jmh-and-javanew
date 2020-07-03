/**
 *
 */
package basics.nosql.redis;

import java.util.concurrent.TimeUnit;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * @author Office
 *
 */
public class TestRedis {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	RedisClient redisClient = RedisClient.create(RedisURI.create("localhost", 8888));
	redisClient.setDefaultTimeout(20, TimeUnit.SECONDS);

	// 开启连接
	StatefulRedisConnection<String, String> connect = redisClient.connect();
	RedisCommands<String, String> cmd = connect.sync();

	// set操作，成功则返回OK
	cmd.set("key", "value-test");
	// get操作，成功命中则返回对应的value，否则返回null
	cmd.get("key");
	// 删除指定的key
	cmd.del("key");
	// 获取redis-server信息，内容极为丰富
	cmd.info();

	// 列表操作
	String[] valuelist = { "China", "Americal", "England" };
	// 将一个或多个值插入到列表头部，此处插入多个
	cmd.lpush("listName", valuelist);
	// 移出并获取列表的第一个元素
	System.out.println(cmd.lpop("listName"));
	// 获取列表长度
	System.out.println(cmd.llen("listName"));
	// 通过索引获取列表中的元素
	System.out.println(cmd.lindex("listName", 1));
	redisClient.shutdown();
    }

}
