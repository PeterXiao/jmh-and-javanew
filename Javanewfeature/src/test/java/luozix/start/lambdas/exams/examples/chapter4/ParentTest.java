    /** 
	 * Project Name:java11_in_action 
	 * File Name:ParentTest.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter4 
	 * Date:2021年2月15日下午12:10:08 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ParentTest.java
* @Package luozix.start.lambdas.exams.examples.chapter4
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 下午12:10:08
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter4;  
	/** 
	 * ClassName:ParentTest <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 下午12:10:08 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
* @ClassName: ParentTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 下午12:10:08
* @version  
*@since JDK 1.8
*/
class ParentTest {

	@Test
	void test() {
		fail("Not yet implemented");
		Optional<String> a = Optional.of("a");
		assertEquals("a", a.get());
		Optional emptyOptional = Optional.empty();
		Optional alsoEmpty = Optional.ofNullable(null);

		assertFalse(emptyOptional.isPresent());

		// 例 4-22 中定义了变量 a assertTrue(a.isPresent());
		assertEquals("b", emptyOptional.orElse("b"));
		assertEquals("c", emptyOptional.orElseGet(() -> "c"));
	}

	@Test
	public void parentDefaultUsed() {
		Parent parent = new ParentImpl();
		parent.welcome();
		assertEquals("Parent: Hi!", parent.getLastMessage());
	}

	@Test
	public void childOverrideDefault() {
		Child child = new ChildImpl();
		child.welcome();
		assertEquals("Child: Hi!", child.getLastMessage());
	}

	@Test
	public void concreteBeatsDefault() {
		Parent parent = new OverridingParent();
		parent.welcome();
		assertEquals("Class Parent: Hi!", parent.getLastMessage());
	}

	@Test
	public void concreteBeatsCloserDefault() {
		Child child = new OverridingChild();
		child.welcome();
		assertEquals("Class Parent: Hi!", child.getLastMessage());
	}


}
