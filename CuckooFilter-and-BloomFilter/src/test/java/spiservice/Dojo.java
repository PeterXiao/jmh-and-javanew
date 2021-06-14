/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:Dojo.java Package Name:spiservice
 * Date:2021年6月13日下午3:02:44 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Dojo.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午3:02:44
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:Dojo <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年6月13日 下午3:02:44 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Dojo @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午3:02:44
 * @version
 * @since JDK 1.8
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO refactor everything that seems legit with `var` (slide 38)
public class Dojo {
  // TODO refactor with Convenience Factory Methods for Collections (slide 13)
  public List<String> list() {
    List<String> theList = new ArrayList<>();
    theList.add("s1");
    theList.add("s2");
    theList.add("s3");
    return theList;
  }

  // TODO refactor with Convenience Factory Methods for Collections (slide 13)
  public Map<String, String> map() {
    Map<String, String> theList = new HashMap<>();
    theList.put("key1", "value1");
    theList.put("key2", "value2");
    theList.put("key3", "value3");
    return theList;
  }

  // TODO refactor with Stream::iterate (slide 24)
  public String streamIterate() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      str.append(i);
    }
    return str.toString();
  }

  // TODO refactor with the new HttpClient (slide 46)
  public String getChuckNorrisJoke() throws IOException {
    URL joke = new URL("https://api.chucknorris.io/jokes/_eh6qfhvs6a1zdhkkzglda");
    HttpURLConnection connection = (HttpURLConnection) joke.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Accept", "application/json");
    connection.connect();

    // read the output from the server
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
      StringBuilder stringBuilder = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line + "\n");
      }
      connection.disconnect();
      return stringBuilder.toString();
    }
  }

  // TODO refactor with LocalDate::datesUntil (slide 30)
  public List<LocalDate> nextTenDates() {
    List<LocalDate> nextTenDates = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      LocalDate date = LocalDate.now().plusDays(i);
      nextTenDates.add(date);
    }

    return nextTenDates;
  }

  // TODO refactor with InputStream::readAllBytes (slide 31)
  public String readAllBytes() throws IOException {
    File file = new File("src/main/resources/file.txt");
    StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      reader.lines().forEach(line -> builder.append(line).append('\n'));
    }
    return builder.substring(0, builder.length() - 1); // we remove the last '\n'
  }

  // TODO refactor with List::copyOf (slide 39)
  public List<String> copyOf(List<String> theList) {
    List<String> copy = new ArrayList<>();
    copy.addAll(theList);
    return Collections.unmodifiableList(copy);
  }

  // TODO refactor with String::repeat (slide 48)
  public String repeate(String str, int n) {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < n; i++) {
      buffer.append(str);
    }
    return buffer.toString();
  }
}
