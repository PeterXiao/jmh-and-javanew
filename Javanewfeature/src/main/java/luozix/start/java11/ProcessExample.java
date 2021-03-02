    /** 
	 * Project Name:java11_in_action 
	 * File Name:ProcessExample.java 
	 * Package Name:luozix.start.java11 
	 * Date:2021年3月2日下午6:27:20 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ProcessExample.java
* @Package luozix.start.java11
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年3月2日 下午6:27:20
* @version V1.0  
*/  
	  
	package luozix.start.java11;  
	/** 
	 * ClassName:ProcessExample <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年3月2日 下午6:27:20 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */ 

/**
* @ClassName: ProcessExample
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年3月2日 下午6:27:20
* @version  
*@since JDK 1.8
*/
public class ProcessExample {

  /**
   * @Title: main @Description: * Java SE 9 迎来一些 Process API 的改进，通过添加一些新的类和方法来优化系统级进程的管控。
   *
   * <p>实际上 JDK 偷偷的在 Java11 又把 API 改了一点。。。不过下面的代码是可以运行的
   *
   * <p>Process API 中的两个新接口：
   *
   * <p>- java.lang.ProcessHandle - java.lang.ProcessHandle.Info
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月2日 下午6:27:20.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ProcessHandle currentProcess = ProcessHandle.current();
    System.out.println("当前进程的 PID = " + currentProcess.pid());
  }
}
