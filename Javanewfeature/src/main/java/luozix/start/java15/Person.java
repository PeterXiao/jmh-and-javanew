/**
 * 
 */
package luozix.start.java15;

/**
 * @author xiaoy
 *
 */
public record Person(String name, int age) {
}

//public record Person(String name, int age) {
//    public Person {
//        if(age < 0) {
//            throw new IllegalArgumentException("Age cannot be negative");
//        }
//    }
//}
//public class Person {
//    private final String name;
//    private final int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//}