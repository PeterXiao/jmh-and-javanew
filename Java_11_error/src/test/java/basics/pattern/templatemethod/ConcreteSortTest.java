package basics.pattern.templatemethod;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcreteSortTest {
	public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 }; // 预设数据数组  
	@Test
	void test() {
        AbstractSort s = new ConcreteSort();  
        s.showSortResult(a);  
	}

}
