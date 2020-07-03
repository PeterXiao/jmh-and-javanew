/**
 *
 */
package basics.nosql.mapdb;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

/**
 * @author Office
 *
 */
public class mapdbTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// import org.mapdb.*
//	DB db = DBMaker.memoryDB().make();
//	ConcurrentMap map = db.hashMap("map").createOrOpen();
//	map.put("something", "here");

//	DB db = DBMaker.fileDB("file.db").fileMmapEnable().make();
//	ConcurrentMap<String, Long> map = db.hashMap("map", Serializer.STRING, Serializer.LONG).createOrOpen();
//	map.put("something", 111L);
//	System.out.println(map.get("something"));
//	db.close();
	DB db = DBMaker.fileDB("file.db").fileMmapEnable().fileMmapEnableIfSupported().fileMmapPreclearDisable()
		.closeOnJvmShutdown().cleanerHackEnable().concurrencyScale(8).make();

	HTreeMap<String, String> hTreeMap = db.hashMap("file_map").keySerializer(Serializer.STRING)
		.valueSerializer(Serializer.STRING).createOrOpen();

	hTreeMap.put("1", "{[2011-01-01,123],[2011-01-01,123]}");
	hTreeMap.put("2", "{[2011-01-01,123],[2011-01-01,123]}");

	System.out.println(hTreeMap.get("1"));
	System.out.println(hTreeMap.get("11"));

	db.close();

    }

}
