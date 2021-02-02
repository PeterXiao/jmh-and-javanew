/**
 * 
 */
package luozix.start.java15.seals.products;

/**
 * @author xiaoy
 *
 */
public sealed interface Expr permits ConstantExpr,NegExpr,PlusExpr,TimesExpr {
}
