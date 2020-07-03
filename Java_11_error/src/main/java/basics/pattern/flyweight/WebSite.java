/**
 * 
 */
package basics.pattern.flyweight;

import java.util.Hashtable;

import cn.hutool.core.lang.Console;

/**
 * @author Office
 *
 */
abstract class WebSite
{
	public abstract void Use(User user);
}
abstract class ConcreteWebSite extends  WebSite
{
	private String name = "";
	public ConcreteWebSite(String name)
	{
		this.name = name;
	}
	

   @Override
	public void Use(User user) {
		// TODO Auto-generated method stub
		//System.out.println("网站分类:" ＋ name + "用户:" + user.getName());
	}
}
/*
class WebSiteFactory
{
	private Hashtable flyweights = new HashTable();
	
	//获得网站分类
	public WebSite GetWebSiteCateegory(String key)
	{
		if (!flyweights.ContainsKey(key))
		flyweights.Add(key, new ConcreteWebSite(key));
		return ((webSite)flyweightskey[key]);
	}
	
	//获得网站分类总数
	public int GetWebSiteCount
	{
		return flyweights.Count;
	}
}

static void Main(string[] args)
{	
	WebSiteFactory f = new WebSiteFactory();
	
	WebSite fx = f.GetWebSiteCategory("产品展示");
	fx.Use(new User("小菜"));
	
	WebSite fy = f.GetWebSiteCategory("产品展示");
	fy.Use(new User("小白"));
		
	WebSite f1 = f.GetWebSiteCategory("博客");
	f1.Use(new User("小黑"));
	
	WebSite f2 = f.GetWebSiteCategory("博客");
	f2.Use(new User("小绿"));
	
	Console.Read();
}*/