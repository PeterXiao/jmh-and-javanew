/**  
* @Title: Predicate.java
* @Package luozix.start.java8.action.beans.lesson02
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:26:50
* @version V1.0  
*/
package luozix.start.java8.action.beans.lesson02;

/**
* @ClassName: Predicate
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月11日 下午5:26:50
*
*/
public interface Predicate<T> {
	boolean test(T t);

}

//class Filter<T> {
//	public static T List<T> filter(List<T> list, Predicate<T> predicate ) {
//		List<T> resultList  =new ArrayList<>();
//	 for(T e: list) {
//		 if(predicate.test(e))
//			 resultList.add(e);
//	 }
//		return resultList;
//	}
//}