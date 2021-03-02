    /** 
	 * Project Name:java11_in_action 
	 * File Name:CollectionsExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:31:39 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: CollectionsExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:31:39
* @version V1.0  
*/  
	  
	package luozix.start.java11;
/**
 * ClassName:CollectionsExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午6:31:39 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import static java.util.Map.entry;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
* @ClassName: CollectionsExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 下午6:31:39
* @version  
*@since JDK 1.8
*/
public class CollectionsExample {

  /**
  * @Title: main
  * @Description: TODO(这里用一句话描述这个方法的作用)
  * @param @param args    设定文件
  * @return void    返回类型
  * date: 2021年3月2日 下午6:31:39.<br/>
  * @author xiaoy 
  * @param args 
  *@since JDK 1.8
  * @throws
  */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // 空列表，数据类型为 Object
    List immutableList = List.of();

    // 创建 List<String>
    var foo = List.of("luozi", "github", "技术小黑屋");

    // 空 Map，Key 和 Value 类型都是 Object
    Map emptyImmutableMap = Map.of();

    // 快速创建一个 Map
    var mmp = Map.of(2017, "先赚他一个亿", 2018, "去年的梦想可能有点儿夸张");

    // 使用 Entries 创建一个 Map
    Map<Integer, String> emptyEntryMap =
        Map.ofEntries(entry(20, "装逼"), entry(30, "单身"), entry(40, "回家种地"));

    // 创建一个 Map.Entry
    Map.Entry<String, String> immutableMapEntry = Map.entry("biezhi", "emmmm");
    // 其实和上面的代码片段是一样一样的
    Map.ofEntries(immutableMapEntry);

    // 创建一个空 Set<String>
    Set<String> immutableSet = Set.of();

    // 快速创建一个 Set<String>
    Set<String> bar = Set.of("我", "可能", "是个", "假的", "程序员");
  }

}
