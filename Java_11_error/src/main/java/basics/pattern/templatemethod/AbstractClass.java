/**
 * 
 */
package basics.pattern.templatemethod;

/**
 * @author Office
 *
 */
abstract class AbstractClass
{
	public abstract void PrimitiveOperation1();
	public abstract void PrimitiveOperation2();
	
	public void TemplateMethod()
	{
		PrimitiveOperation1();
		PrimitiveOperation2();
		//console.WriteLine("");
	}
}
