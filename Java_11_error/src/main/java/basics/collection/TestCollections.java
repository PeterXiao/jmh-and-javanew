/**
 *
 */
package basics.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Office
 *
 */
public class TestCollections {
    public static void main(String[] args) {
	StudentVO student = null;
	long begin1 = System.currentTimeMillis();
	List<StudentVO> list1 = new ArrayList<>();
	for (int i = 0; i < 1000000; i++) {
	    student = new StudentVO(i, "chenssy_" + i, i);
	    list1.add(student);
	}
	long end1 = System.currentTimeMillis();
	System.out.println("list1 time：" + (end1 - begin1));

	long begin2 = System.currentTimeMillis();
	List<StudentVO> list2 = new ArrayList<>(1000000);
	for (int i = 0; i < 1000000; i++) {
	    student = new StudentVO(i, "chenssy_" + i, i);
	    list2.add(student);
	}
	long end2 = System.currentTimeMillis();
	System.out.println("list2 time：" + (end2 - begin2));
    }
}
