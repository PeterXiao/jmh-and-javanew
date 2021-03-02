/**
 * Project Name:java11_in_action File Name:Car.java Package Name:luozix.start.perf.cqengine
 * Date:2021年3月2日下午11:33:50 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Car.java @Package luozix.start.perf.cqengine @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午11:33:50
 * @version V1.0
 */
package luozix.start.perf.cqengine;

/**
 * @ClassName: Car @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午11:33:50
 * @version
 * @since JDK 1.8
 */
public class Car {
  //
  //  public static final SimpleAttribute<Car, Integer> CAR_ID =
  //      new SimpleAttribute<Car, Integer>("carId") {
  //        @Override
  //        public Integer getValue(Car car, QueryOptions queryOptions) {
  //          return car.carId;
  //        }
  //      };
  //
  //  public static final SimpleAttribute<Car, String> MANUFACTURER =
  //      new SimpleAttribute<Car, String>("manufacturer") {
  //        @Override
  //        public String getValue(Car car, QueryOptions queryOptions) {
  //          return car.manufacturer;
  //        }
  //      };
  //
  //  public static final SimpleAttribute<Car, String> MODEL =
  //      new SimpleAttribute<Car, String>("model") {
  //        @Override
  //        public String getValue(Car car, QueryOptions queryOptions) {
  //          return car.model;
  //        }
  //      };
  //
  //  public static final SimpleAttribute<Car, Color> COLOR =
  //      new SimpleAttribute<Car, Color>("color") {
  //        @Override
  //        public Color getValue(Car car, QueryOptions queryOptions) {
  //          return car.color;
  //        }
  //      };
  //
  //  public static final SimpleAttribute<Car, Integer> DOORS =
  //      new SimpleAttribute<Car, Integer>("doors") {
  //        @Override
  //        public Integer getValue(Car car, QueryOptions queryOptions) {
  //          return car.doors;
  //        }
  //      };
  //
  //  public static final SimpleAttribute<Car, Double> PRICE =
  //      new SimpleAttribute<Car, Double>("price") {
  //        @Override
  //        public Double getValue(Car car, QueryOptions queryOptions) {
  //          return car.price;
  //        }
  //      };
  //
  //  public static final MultiValueAttribute<Car, String> FEATURES =
  //      new MultiValueAttribute<Car, String>("features") {
  //        @Override
  //        public Iterable<String> getValues(Car car, QueryOptions queryOptions) {
  //          return car.features;
  //        }
  //      };
  //
  //  public static final MultiValueAttribute<Car, String> KEYWORDS =
  //      new MultiValueAttribute<Car, String>("keywords") {
  //        @Override
  //        public Iterable<String> getValues(Car car, QueryOptions queryOptions) {
  //          return car.keywords;
  //        }
  //      };
  //
  //  public enum Color {
  //    RED,
  //    GREEN,
  //    BLUE,
  //    BLACK,
  //    WHITE
  //  }
  //
  //  final int carId;
  //  final String manufacturer;
  //  final String model;
  //  final Color color;
  //  final int doors;
  //  final double price;
  //  final List<String> features;
  //  final List<String> keywords;
  //
  //  public Car(
  //      int carId,
  //      String manufacturer,
  //      String model,
  //      Color color,
  //      int doors,
  //      double price,
  //      List<String> features,
  //      List<String> keywords) {
  //    this.carId = carId;
  //    this.manufacturer = manufacturer;
  //    this.model = model;
  //    this.color = color;
  //    this.doors = doors;
  //    this.price = price;
  //    this.features = features;
  //    this.keywords = keywords;
  //  }
  //
  //  public int getCarId() {
  //    return carId;
  //  }
  //
  //  public String getManufacturer() {
  //    return manufacturer;
  //  }
  //
  //  public String getModel() {
  //    return model;
  //  }
  //
  //  public Color getColor() {
  //    return color;
  //  }
  //
  //  public int getDoors() {
  //    return doors;
  //  }
  //
  //  public double getPrice() {
  //    return price;
  //  }
  //
  //  public List<String> getFeatures() {
  //    return features;
  //  }
  //
  //  @Override
  //  public String toString() {
  //    return "Car{"
  //        + "carId="
  //        + carId
  //        + ", manufacturer='"
  //        + manufacturer
  //        + '\''
  //        + ", model='"
  //        + model
  //        + '\''
  //        + ", color="
  //        + color
  //        + ", doors="
  //        + doors
  //        + ", price="
  //        + price
  //        + ", features="
  //        + features
  //        + ", keywords="
  //        + keywords
  //        + '}';
  //  }
  //
  //  @Override
  //  public boolean equals(Object o) {
  //    if (this == o) return true;
  //    if (!(o instanceof Car)) return false;
  //
  //    Car car = (Car) o;
  //
  //    if (carId != car.carId) return false;
  //
  //    return true;
  //  }
  //
  //  @Override
  //  public int hashCode() {
  //    return carId;
  //  }
}
