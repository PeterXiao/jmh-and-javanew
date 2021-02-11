/**  
* @Title: MyClassFilterTest.java
* @Package luozix.start.nashorn
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午1:36:35
* @version V1.0  
*/
package luozix.start.nashorn;
/**
* @ClassName: MyClassFilterTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午1:36:35
*
*/
//import javax.script.ScriptEngine;
//import jdk.nashorn.api.scripting.ClassFilter;
//import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
// 
//public class MyClassFilterTest {
// 
//  class MyCF implements ClassFilter {
//    @Override
//    public boolean exposeToScripts(String s) {
//      if (s.compareTo("java.io.File") == 0) return false;
//      return true;
//    }
//  }
// 
//  public void testClassFilter() {
// 
//    final String script =
//      "print(java.lang.System.getProperty(\"java.home\"));" +
//      "print(\"Create file variable\");" +
//      "var File = Java.type(\"java.io.File\");";
// 
//    NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
// 
//    ScriptEngine engine = factory.getScriptEngine(
//      new MyClassFilterTest.MyCF());
//    try {
//      engine.eval(script);
//    } catch (Exception e) {
//      System.out.println("Exception caught: " + e.toString());
//    }
//  }
// 
//  public static void main(String[] args) {
//    MyClassFilterTest myApp = new MyClassFilterTest();
//    myApp.testClassFilter();
//  }
//}
