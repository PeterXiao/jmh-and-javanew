/**
 * 
 */
package luozix.start.java15.seals;

import luozix.start.java15.seals.products.ConstantExpr;
import luozix.start.java15.seals.products.Expr;
import luozix.start.java15.seals.products.NegExpr;
import luozix.start.java15.seals.products.PlusExpr;
import luozix.start.java15.seals.products.TimesExpr;

/**
 * @author xiaoy
 *
 */
public class SealedApp {

	public static void main(String[] args) {

		// y = x * 2 + 1

		var x = 3;
		int y = calculate(new PlusExpr(new TimesExpr(new ConstantExpr(x), new ConstantExpr(2)), new ConstantExpr(1)));
		System.out.println("Value of y: " + y);

	}

	private static int calculate(Expr expr) {
		if (expr instanceof ConstantExpr e) {
			return e.value();
		} else if (expr instanceof PlusExpr e) {
			return calculate(e.first()) + calculate(e.second());
		} else if (expr instanceof TimesExpr e) {
			return calculate(e.first()) * calculate(e.second());
		} else if (expr instanceof NegExpr e) {
			return -calculate(e.expr());
		} else {
			throw new RuntimeException("There is no such case " + expr);
		}
	}
}
