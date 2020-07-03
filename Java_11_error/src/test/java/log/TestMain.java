/**
 *
 */
package log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.facebook.tools.io.IO;


/**
 * @author LiY
 * @time 下午11:07:56
 */
public class TestMain {

	/**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		 final Disruptor<ObjectEvent<String>> disruptor = new Disruptor<>(() -> ObjectEvent<String>(), bufferSize, executor);
//			    disruptor
//			        .handleEventsWith(new ProcessingEventHandler())
//			        .then(new ClearingObjectHandler());

	var url = new URL("http://www.oracle.com/");
	var conn = url.openConnection();
	var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	System.out.println(IO.class.getClass());
	}

}
