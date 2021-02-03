/**
 * 
 */
package luozix.start.exams.funcs;

/**
 * @author xiaoy
 *
 */
public class LabelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strSearch = "This is the string in which you have to search for a substring.";
		String substring = "substring";
		boolean found = false;
		int max = strSearch.length() - substring.length();
		testlbl: for (int i = 0; i <= max; i++) {
			int length = substring.length();
			int j = i;
			int k = 0;
			while (length-- != 0) {
				if (strSearch.charAt(j++) != substring.charAt(k++)) {
					continue testlbl;
				}
			}
			found = true;
			break testlbl;
		}
		if (found) {
			System.out.println("发现子字符串。");
		} else {
			System.out.println("字符串中没有发现子字符串。");
		}

		Car c;
		c = Car.tata;
		switch (c) {
		case lamborghini:
			System.out.println("你选择了 lamborghini!");
			break;
		case tata:
			System.out.println("你选择了 tata!");
			break;
		case audi:
			System.out.println("你选择了 audi!");
			break;
		case fiat:
			System.out.println("你选择了 fiat!");
			break;
		case honda:
			System.out.println("你选择了 honda!");
			break;
		default:
			System.out.println("我不知道你的车型。");
			break;
		}

		System.out.println("所有汽车的价格：");
		for (Cars ccar : Cars.values())
			System.out.println(ccar + " 需要 " + ccar.getPrice() + " 千美元。");
	}

}

enum Car {
	lamborghini, tata, audi, fiat, honda
}

enum Cars {
	lamborghini(900), tata(2), audi(50), fiat(15), honda(12);

	private int price;

	Cars(int p) {
		price = p;
	}

	int getPrice() {
		return price;
	}
}