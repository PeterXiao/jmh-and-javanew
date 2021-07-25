/**
 * 
 */
package edu.buet.main;

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
  public static void swap(Person per1, Person per2) {
    System.out.println("per1：" + per1 + "  per2：" + per2);
    Person temp = per1;
    per1 = per2;
    per2 = temp;
    System.out.println("per1：" + per1 + "  per2：" + per2);
  }

  public static void main(String[] args) {
    Person p1 = new Person(18);
    Person p2 = new Person(20);
    System.out.println("调用前p1：" + p1 + "  p2：" + p2);
    swap(p1, p2);
    System.out.println("调用后p1：" + p1 + "  p2：" + p2);
  }
}
