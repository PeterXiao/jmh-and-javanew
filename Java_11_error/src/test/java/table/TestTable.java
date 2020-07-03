/**
 *
 */
package table;

import org.testng.annotations.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @author LiY
 * @time 下午4:12:04
 */
public class TestTable {

	/**
	 * 数据表结构 类似于 Map<FirstName, Map<LastName, Person>>
	 */
	@Test
	public void testTable() {

		final Table<String, Integer, String> table = HashBasedTable.create();
		for (char i = 'a'; i < 'f'; i++) {
			for (Integer j = 1; j < 6; j++) {
				table.put(String.valueOf(i), j, String.valueOf(i) + "" + j);
			}
		}
		/**
		 * 初始化一个5行5列的表 { d={1=d1, 2=d2, 3=d3, 4=d4, 5=d5}, e={1=e1, 2=e2, 3=e3, 4=e4,
		 * 5=e5}, b={1=b1, 2=b2, 3=b3, 4=b4, 5=b5}, c={1=c1, 2=c2, 3=c3, 4=c4, 5=c5},
		 * a={1=a1, 2=a2, 3=a3, 4=a4, 5=a5} }
		 */
		System.out.println(table);

		// 列2
		System.out.println(table.column(2)); // {d=d2, e=e2, b=b2, c=c2, a=a2}
		// 行e
		System.out.println(table.row("e")); // {1=e1, 2=e2, 3=e3, 4=e4, 5=e5}
		// 获取 b行3列的值
		System.out.println(table.get("b", 3)); // b3
		// 判断是否包含 a行6列
		System.out.println(table.contains("a", 6)); // false
		System.out.println(table.contains("a", 3)); // true
		System.out.println(table.containsColumn("b")); // false
		System.out.println(table.containsColumn(4)); // true
		System.out.println(table.containsRow("b")); // true
		System.out.println(table.containsValue("b5")); // true

		// 转换为Map<columnKey,Map<rowKey,value>>
		// {1={d=d1, e=e1, b=b1, c=c1, a=a1}, 2={d=d2, e=e2, b=b2, c=c2, a=a2}, 3={d=d3,
		// e=e3, b=b3, c=c3, a=a3}, 4={d=d4, e=e4, b=b4, c=c4, a=a4}, 5={d=d5, e=e5,
		// b=b5, c=c5, a=a5}}
		System.out.println(table.columnMap());

		// 转换为Map<rowKey,Map<columnKey,value>>
		// {d={1=d1, 2=d2, 3=d3, 4=d4, 5=d5}, e={1=e1, 2=e2, 3=e3, 4=e4, 5=e5}, b={1=b1,
		// 2=b2, 3=b3, 4=b4, 5=b5}, c={1=c1, 2=c2, 3=c3, 4=c4, 5=c5}, a={1=a1, 2=a2,
		// 3=a3, 4=a4, 5=a5}}
		System.out.println(table.rowMap());

		// cellSet 是一个 (rowKey,columnKey)=value 的set集合
		// [(d,1)=d1, (d,2)=d2, (d,3)=d3, (d,4)=d4, (d,5)=d5, (e,1)=e1, (e,2)=e2,
		// (e,3)=e3, (e,4)=e4, (e,5)=e5, (b,1)=b1, (b,2)=b2, (b,3)=b3, (b,4)=b4,
		// (b,5)=b5, (c,1)=c1, (c,2)=c2, (c,3)=c3, (c,4)=c4, (c,5)=c5, (a,1)=a1,
		// (a,2)=a2, (a,3)=a3, (a,4)=a4, (a,5)=a5]
		System.out.println(table.cellSet());

		// 行的集合
		// [d, e, b, c, a]
		System.out.println(table.rowKeySet());
		// 列的集合
		// [1, 2, 3, 4, 5]
		System.out.println(table.columnKeySet());

		// 删除 a行3列
		table.remove("a", 3);
		System.out.println(table);

		// 清空表数据
		table.clear();
		System.out.println(table);

	}
}
