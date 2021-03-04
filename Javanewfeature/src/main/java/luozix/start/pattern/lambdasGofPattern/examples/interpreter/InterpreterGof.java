/**
 * Project Name:java11_in_action File Name:InterpreterGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.interpreter Date:2021年3月4日下午6:05:52
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: InterpreterGof.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.interpreter @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:05:52
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.interpreter;
/**
 * ClassName:InterpreterGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:05:52 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: InterpreterGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:05:52
 * @version
 * @since JDK 1.8
 */
import java.util.Stack;

public class InterpreterGof {

  interface Expression {
    int interpret();
  }

  public static class Add implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) {
      this.leftExpression = leftExpression;
      this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
      return leftExpression.interpret() + rightExpression.interpret();
    }
  }

  public static class Subtract implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Subtract(Expression leftExpression, Expression rightExpression) {
      this.leftExpression = leftExpression;
      this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
      return leftExpression.interpret() - rightExpression.interpret();
    }
  }

  public static class Product implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public Product(Expression leftExpression, Expression rightExpression) {
      this.leftExpression = leftExpression;
      this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
      return leftExpression.interpret() * rightExpression.interpret();
    }
  }

  public static class Number implements Expression {
    private final int n;

    public Number(int n) {
      this.n = n;
    }

    @Override
    public int interpret() {
      return n;
    }
  }

  public static boolean isOperator(String s) {
    if (s.equals("+") || s.equals("-") || s.equals("*")) return true;
    else return false;
  }

  public static Expression getOperator(String s, Expression left, Expression right) {
    switch (s) {
      case "+":
        return new Add(left, right);
      case "-":
        return new Subtract(left, right);
      case "*":
        return new Product(left, right);
    }
    return null;
  }

  public static int evaluate(String expression) {
    Stack<Expression> stack = new Stack<>();
    for (String s : expression.split(" ")) {
      if (isOperator(s)) {
        Expression right = stack.pop();
        Expression left = stack.pop();
        stack.push(getOperator(s, left, right));
      } else {
        Expression i = new Number(Integer.parseInt(s));
        stack.push(i);
      }
    }
    return stack.pop().interpret();
  }

  public static void main(String[] args) {
    String expression = "7 3 - 2 1 + *";
    System.out.println(evaluate(expression));
  }
}
