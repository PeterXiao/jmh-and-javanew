/**
 * Project Name:java11_in_action File Name:InterpreterLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.interpreter Date:2021年3月4日下午6:06:13
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: InterpreterLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.interpreter @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:06:13
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.interpreter;
/**
 * ClassName:InterpreterLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:06:13 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: InterpreterLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:06:13
 * @version
 * @since JDK 1.8
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class InterpreterLambda {
  static Map<String, IntBinaryOperator> opMap = new HashMap<>();

  static {
    opMap.put("+", (a, b) -> a + b);
    opMap.put("*", (a, b) -> a * b);
    opMap.put("-", (a, b) -> a - b);
  }

  public static int evaluate(String expression) {
    Stack<Integer> stack = new Stack<>();
    for (String s : expression.split(" ")) {
      IntBinaryOperator op = opMap.get(s);
      if (op != null) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(op.applyAsInt(left, right));
      } else {
        stack.push(Integer.parseInt(s));
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    String expression = "7 3 - 2 1 + *";
    System.out.println(evaluate(expression));
  }
}
