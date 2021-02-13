/**  
* @Title: StrategyLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:04:46
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: StrategyLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:04:46
*
*/
import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyLambda {

	public static void publishText(String text, Predicate<String> filter, Function<String, String> formatter) {
		if (filter.test(text)) {
			System.out.println(formatter.apply(text));
		}
	}

	public static void main(String[] args) {
		publishText("ERROR: An error detected", s -> s.startsWith("ERROR"), String::toUpperCase);
	}
}