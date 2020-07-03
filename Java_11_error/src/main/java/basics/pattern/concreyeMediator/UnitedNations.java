package basics.pattern.concreyeMediator;

abstract class Country
{
	protected UnitedNations mediator;
	
	public Country(UnitedNations mediator)
	{
		this.mediator = mediator;
	}
}
//联合国机构
abstract class UnitedNations
{
	//声明
	public abstract void Declare(String message,Country colleagues);
}


/*class USA: Country
{
	public USA(UnitedNations mediator): base(mediator)
	{}
	//声明
	public void Declare(string message)
	{
		mediator.Declare(message, this);
	}
	
	//获得消息
	public void GetMessage(string message)
	{
		Console.WriteLine("美国获得对方消息" + message);
	}
}

class Iraq: Country
{
	public Iraq(UnitedNations mediator): base(mediator)
	{}
	//声明
	public void Declare(string message)
	{
		mediator.Declare(message, this);
	}
	
	//获得消息
	public void GetMessage(string message)
	{
		Console.WriteLine("美国获得对方消息" + message);
	}
}
//联合国安全理事会
class UnitedNationsSecurityCouncil: UnitedNations
{
	private USA colleague1;
	private Iraq colleague2;
	
	//美国
	public USA Colleague1
	{
		set {colleague1 = value;}
	}
	
	//伊拉克
		public Iraq Colleague2
	{
		set {colleague2 = value;}
	}
	
	//声明
	public override void Declare(string message, Country colleague)
	{
		if(colleague == colleague1)
		{
			colleague2.GetMessage(message);
		}else
		{
			colleague1.GetMessage(message);
		}
	}
}

static void Main(string[] args)
{
	UnitedNationsSecurityCouncil UNSC = new UnitedNationsSecurityCouncil();
	
	USA c1 = new USA(UNSC);
	Iraq c2 = new Iraq(UNSC);
	
	UNSC.Colleague1 = c1;
	UNSC.Colleague2 = c2;
	
	c1.Declare("不准研发核武器");
	c2.Declare("我们没有，但我们不怕侵略");
	
	Console.Read();	
}
* 但是，由于ConcreyeMediator控制了集中化，于是就把交互复杂性变为了中介者的复杂性，这就使得中介者会变得比任何一个ConcreteColleague都复杂。
*/