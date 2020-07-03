package basics.maps;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import cn.hutool.core.lang.Console;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * @author Office
 *
 */
public class TestMap {

	// 自动选择日志实现
	//static Log log = LogFactory.get();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//log.debug("This is {} log", "default");
		Console.log("----------------------------------------------------------------------");
		Map<String, HashSet<String>> mapexample = new HashedMap<>();
		Multimap<String, String> myMultimap = ArrayListMultimap.create();
		Long long1 = System.nanoTime();
		
		for(int i =0; i<=1000000; i++) {
			
			myMultimap.put("Fruits", "apple"+i);
			myMultimap.put("Fruits", "orange"+i);	
			myMultimap.put("Fruits", "apple"+i);	
		
		}
		
		Long funs =System.nanoTime() -long1;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(funs)+"ms");
		Long long11 = System.nanoTime();
		for(int i =0; i<=1000000; i++) {
			
			mapexample.computeIfAbsent("fruits", k->getValue(k)).add("apple"+i);
			mapexample.computeIfAbsent("fruits", k->getValue(k)).add("orange"+i);
			mapexample.computeIfAbsent("fruits", k->getValue(k)).add("apple"+i);
	
			
			}
		funs =System.nanoTime() -long1;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(funs)+"ms");	
		
		//log.error("", mapexample);
	}

	public static final String NAME = "";
	@SuppressWarnings("unused")
	private static HashSet<String> getValue(String key) {
		return new HashSet<>();
		
	}
}
