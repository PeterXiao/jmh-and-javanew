/**
 * 
 */
package jvm;

/**
 * @author xiaoy
 *
 */
class Person {
  private int age;

  public Person(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}


public class someInterface {
  public static void add(Person per) {
    per.setAge(per.getAge() + 1);
  }

  public static void main(String[] args) {
    Person p = new Person(18);
    System.out.println("调用前age为：" + p.getAge());
    add(p);
    System.out.println("调用后age为：" + p.getAge());
  }
}
