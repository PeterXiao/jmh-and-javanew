/** */
package luozix.start.java8;

/**
 * @author xiaoy
 * @description Nashorn JavaScript引擎
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EngineTest {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    System.out.println(engine.getClass().getName());
    try {
      System.out.println("Result: " + engine.eval("funsction f() { return 1; }; f() + 1;"));
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }
}
