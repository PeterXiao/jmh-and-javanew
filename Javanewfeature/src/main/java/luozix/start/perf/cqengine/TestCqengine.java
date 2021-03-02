/**
 * Project Name:java11_in_action File Name:TestCqengine.java Package Name:luozix.start.perf.cqengine
 * Date:2021年3月2日下午11:09:54 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TestCqengine.java @Package luozix.start.perf.cqengine @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午11:09:54
 * @version V1.0
 */
package luozix.start.perf.cqengine;

/**
* @ClassName: TestCqengine
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 下午11:09:54
* @version  
*@since JDK 1.8
*/
public class TestCqengine {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月2日 下午11:09:54.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // Create an indexed collection (note: could alternatively use CQEngine.copyFrom() existing
    // collection)...
    //    IndexedCollection<Car> cars = new ConcurrentIndexedCollection<Car>();
    //
    //    // Add some indexes...
    //    cars.addIndex(NavigableIndex.onAttribute(Car.CAR_ID));
    //    cars.addIndex(ReversedRadixTreeIndex.onAttribute(Car.NAME));
    //    cars.addIndex(SuffixTreeIndex.onAttribute(Car.DESCRIPTION));
    //    cars.addIndex(HashIndex.onAttribute(Car.FEATURES));
    //
    //    // Add some objects to the collection...
    //    cars.add(
    //        new Car(
    //            1,
    //            "ford focus",
    //            "great condition, low mileage",
    //            Arrays.asList("spare tyre", "sunroof")));
    //    cars.add(
    //        new Car(
    //            2,
    //            "ford taurus",
    //            "dirty and unreliable, flat tyre",
    //            Arrays.asList("spare tyre", "radio")));
    //    cars.add(new Car(3, "honda civic", "has a flat tyre and high mileage",
    // Arrays.asList("radio")));
    //
    //    // -------------------------- Run some queries --------------------------
    //    System.out.println("Cars whose name ends with 'vic' or whose id is less than 2:");
    //    Query<Car> query1 = or(endsWith(Car.NAME, "vic"), lessThan(Car.CAR_ID, 2));
    //    cars.retrieve(query1).forEach(System.out::println);
    //
    //    System.out.println("\nCars whose flat tyre can be replaced:");
    //    Query<Car> query2 =
    //        and(contains(Car.DESCRIPTION, "flat tyre"), equal(Car.FEATURES, "spare tyre"));
    //    cars.retrieve(query2).forEach(System.out::println);
    //
    //    System.out.println("\nCars which have a sunroof or a radio but are not dirty:");
    //    Query<Car> query3 =
    //        and(in(Car.FEATURES, "sunroof", "radio"), not(contains(Car.DESCRIPTION, "dirty")));
    //    cars.retrieve(query3).forEach(System.out::println);
  }
}
