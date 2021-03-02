/**
 * Project Name:java11_in_action File Name:CarFactory.java Package Name:luozix.start.perf.cqengine
 * Date:2021年3月2日下午11:34:26 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CarFactory.java @Package luozix.start.perf.cqengine @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午11:34:26
 * @version V1.0
 */
package luozix.start.perf.cqengine;

/**
 * @ClassName: CarFactory @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午11:34:26
 * @version
 * @since JDK 1.8
 */
public class CarFactory {

  //  public static Set<Car> createCollectionOfCars(int numCars) {
  //    Set<Car> cars = new LinkedHashSet<Car>(numCars);
  //    for (int carId = 0; carId < numCars; carId++) {
  //      cars.add(createCar(carId));
  //    }
  //    return cars;
  //  }
  //
  //  public static Iterable<Car> createIterableOfCars(final int numCars) {
  //    final AtomicInteger count = new AtomicInteger();
  //    return new Iterable<Car>() {
  //      @Override
  //      public Iterator<Car> iterator() {
  //        return new LazyIterator<Car>() {
  //          @Override
  //          protected Car computeNext() {
  //            int carId = count.getAndIncrement();
  //            return carId < numCars ? createCar(carId) : endOfData();
  //          }
  //        };
  //      }
  //    };
  //  }
  //
  //  public static Car createCar(int carId) {
  //    switch (carId % 10) {
  //      case 0:
  //        return new Car(
  //            carId, "Ford", "Focus", Car.Color.RED, 5, 5000.00, noFeatures(), noKeywords());
  //      case 1:
  //        return new Car(
  //            carId, "Ford", "Fusion", Car.Color.RED, 4, 3999.99, asList("hybrid"),
  // asList("zulu"));
  //      case 2:
  //        return new Car(
  //            carId,
  //            "Ford",
  //            "Taurus",
  //            Car.Color.GREEN,
  //            4,
  //            6000.00,
  //            asList("grade a"),
  //            asList("alpha"));
  //      case 3:
  //        return new Car(
  //            carId,
  //            "Honda",
  //            "Civic",
  //            Car.Color.WHITE,
  //            5,
  //            4000.00,
  //            asList("grade b"),
  //            asList("bravo"));
  //      case 4:
  //        return new Car(
  //            carId,
  //            "Honda",
  //            "Accord",
  //            Car.Color.BLACK,
  //            5,
  //            3000.00,
  //            asList("grade c"),
  //            asList("very-good"));
  //      case 5:
  //        return new Car(
  //            carId, "Honda", "Insight", Car.Color.GREEN, 3, 5000.00, noFeatures(),
  // asList("alpha"));
  //      case 6:
  //        return new Car(
  //            carId,
  //            "Toyota",
  //            "Avensis",
  //            Car.Color.GREEN,
  //            5,
  //            5999.95,
  //            noFeatures(),
  //            asList("very-good-car"));
  //      case 7:
  //        return new Car(
  //            carId,
  //            "Toyota",
  //            "Prius",
  //            Car.Color.BLUE,
  //            3,
  //            8500.00,
  //            asList("sunroof", "hybrid"),
  //            noKeywords());
  //      case 8:
  //        return new Car(
  //            carId,
  //            "Toyota",
  //            "Hilux",
  //            Car.Color.RED,
  //            5,
  //            7800.55,
  //            noFeatures(),
  //            asList("very-good-car"));
  //      case 9:
  //        return new Car(
  //            carId, "BMW", "M6", Car.Color.BLUE, 2, 9000.23, asList("coupe"), asList("zulu"));
  //      default:
  //        throw new IllegalStateException();
  //    }
  //  }
  //
  //  static List<String> noFeatures() {
  //    return Collections.<String>emptyList();
  //  }
  //
  //  static List<String> noKeywords() {
  //    return Collections.<String>emptyList();
  //  }
}
