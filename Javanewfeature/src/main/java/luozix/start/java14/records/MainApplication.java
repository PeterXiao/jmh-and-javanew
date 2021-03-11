    /**
	 * Project Name:java11_in_action
	 * File Name:MainApplication.java
	 * Package Name:luozix.start.java14.records
	 * Date:2021年3月10日下午7:01:48
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
	 * 
	*/
	/**
* @Title: MainApplication.java
* @Package luozix.start.java14.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:01:48
* @version V1.0
*/
	  
	package luozix.start.java14.records;
	/**
	 * ClassName:MainApplication <br/>
	 * Function: TODO ADD FUNCTION. <br/>
	 * Reason:   TODO ADD REASON. <br/>
	 * Date:     2021年3月10日 下午7:01:48 <br/>
	 * @author   xiaoy
	 * @version
	 * @since    JDK 1.8
	 * @see
	 */

/**
* @ClassName: MainApplication
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:01:48
* @version
*@since JDK 1.8
*/
public class MainApplication {
////record_default_constructor
    
    public record Person(String name, Integer age) {
        public Person(String name, Integer age) {
            if (name != null && age > 0) {
                this.name = name;
                this.age = age;
            } else {
                throw new IllegalArgumentException("Invalid values");
            }
        }
    }

    public static void main(String[] args) {
        var person1 = new Person("Katerina", 35);
        var person2 = new Person("Lena", 44);

        System.out.println("Object\t\t: " + person1);
        System.out.println("Equals\t\t: " + person1.equals(person2));
        System.out.println("Name\t\t: " + person1.name());
        System.out.println("Age\t\t\t: " + person1.age());
        System.out.println("HashCode\t: " + person1.hashCode());

        System.out.println("--------------------------------------");

        System.out.println("Object\t\t: " + person2);
        System.out.println("Equals\t\t: " + person2.equals(person1));
        System.out.println("Name\t\t: " + person2.name());
        System.out.println("Age\t\t\t: " + person2.age());
        System.out.println("HashCode\t: " + person2.hashCode());
    }
    
    
}
