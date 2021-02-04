/**  
* @Title: CustomizeHandle.java
* @Package luozix.start.exams.daop
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:09:18
* @version V1.0  
*/
package luozix.start.exams.daop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @ClassName: CustomizeHandle
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:09:18
*
*/
public class CustomizeHandle implements InvocationHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(CustomizeHandle.class);

	private Object target;

	public CustomizeHandle(Class clazz) {
		try {
			this.target = clazz.newInstance();
		} catch (InstantiationException e) {
			LOGGER.error("InstantiationException", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("IllegalAccessException", e);
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		before();
		Object result = method.invoke(target, args);
		after();

		LOGGER.info("proxy class={}", proxy.getClass());
		return result;
	}

	private void before() {
		LOGGER.info("handle before");
	}

	private void after() {
		LOGGER.info("handle after");
	}

//	@Test
//	public void test() {
//		CustomizeHandle handle = new CustomizeHandle(ISubjectImpl.class);
//		ISubject subject = (ISubject) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(),
//				new Class[] { ISubject.class }, handle);
//		subject.execute();
//	}
//
//	@Test
//	public void clazzTest() {
//		byte[] proxyClassFile = ProxyGenerator.generateProxyClass("$Proxy1", new Class[] { ISubject.class }, 1);
//		try {
//			FileOutputStream out = new FileOutputStream("/Users/chenjie/Documents/$Proxy1.class");
//			out.write(proxyClassFile);
//			out.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
