    /**
	 * Project Name:java11_in_action
	 * File Name:MainAppli.java
	 * Package Name:luozix.start.java14.records
	 * Date:2021年3月10日下午7:08:16
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
	 * 
	*/
	/**
* @Title: MainAppli.java
* @Package luozix.start.java14.records
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:08:16
* @version V1.0
*/
	  
	package luozix.start.java14.records;
	/**
	 * ClassName:MainAppli <br/>
	 * Function: TODO ADD FUNCTION. <br/>
	 * Reason:   TODO ADD REASON. <br/>
	 * Date:     2021年3月10日 下午7:08:16 <br/>
	 * @author   xiaoy
	 * @version
	 * @since    JDK 1.8
	 * @see
	 */

/**
* @ClassName: MainAppli
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月10日 下午7:08:16
* @version
*@since JDK 1.8
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

record Person(String name, int age) implements Serializable {
    public Person {
        System.out.println("record Person");
    }
}

public class MainAppli {
    public static void main(String[] args) {
        var person = new Person("Katerina", 35);
        writeToFile(person, "myFile.txt");
        System.out.println(readFromFile("myFile.txt"));

    }

    static void writeToFile(Person obj, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            System.out.println("writeToFile\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Person readFromFile(String path) {
        Person result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            result = (Person) ois.readObject();
            System.out.println("readFromFile\n");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
