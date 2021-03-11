    /**
	 * Project Name:java11_in_action
	 * File Name:MyApp.java
	 * Package Name:luozix.start.java14.records
	 * Date:2021年3月10日下午7:05:21
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
	 * 
	*/
	/**
* @Title: MyApp.java
* @Package luozix.start.java14.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:05:21
* @version V1.0
*/
	  
	package luozix.start.java14.records.generics;
	/**
	 * ClassName:MyApp <br/>
	 * Function: TODO ADD FUNCTION. <br/>
	 * Reason:   TODO ADD REASON. <br/>
	 * Date:     2021年3月10日 下午7:05:21 <br/>
	 * @author   xiaoy
	 * @version
	 * @since    JDK 1.8
	 * @see
	 */



/**
* @ClassName: MyApp
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:05:21
* @version
*@since JDK 1.8
*/
	
	  class Department {
	      public Department() {
	          System.out.println("class Department");
	          
	      }
	  }

	  record Person<T>(T info, String name, Integer age, double length, double weight) {
	      public Person {
	          System.out.println("record Person");
	      }
	  }
public class MyApp {

  /**
  * @Title: main
  * @Description: TODO(这里用一句话描述这个方法的作用)
  * @param @param args    设定文件
  * @return void    返回类型
  * date: 2021年3月10日 下午7:05:21.<br/>
  * @author xiaoy
  * @param args
  *@since JDK 1.8
  * @throws
  */
    //_002_record_generics
  public static void main(String[] args) {
  // TODO Auto-generated method stub
      Person<Department> person = new Person<>(new Department(), "Katerina", 35, 1.72, 65);
      System.out.println(person);
  
  }

}
