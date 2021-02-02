/**
 * 
 */
package luozix.start.exams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoy
 *
 */
public class TestStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Any local variable declaration
		List<String> list = new ArrayList<String>();
		//Stream<String> stream = getStream();
		// For Lambda Expression.
		// (String a, String b) -> a.concat(b);
		// Any local variable declaration.
		var listvar = new ArrayList<String>();
//		var stream = getStream();
//		// For Lambda Expression.
//		(var a, var b) -> a.concat(b)

//		List<Employee> employeeList = Arrays.asList(
//	            new Employee(1, "A", 100),
//	            new Employee(2, "B", 200),
//	            new Employee(3, "C", 300),
//	            new Employee(4, "D", 400));
//
//	    HashMap<String, Employee> result = employeeList.stream().collect(
//	            Collectors.teeing(
//	                    Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
//	                    Collectors.minBy(Comparator.comparing(Employee::getSalary)),
//	                    (e1, e2) -> {
//	                        HashMap<String, Employee> map = new HashMap();
//	                        map.put("MAX", e1.get());
//	                        map.put("MIN", e2.get());
//	                        return map;
//	                    }
//	            ));
//
//	    System.out.println(result);
	}

	public String getTextViaArrow(int number) {
		String result = switch (number) {
		case 1, 2 -> "one or two";
		case 3 -> "three";
		case 4, 5, 6 -> "four or five or six";
		default -> "unknown";
		};
		return result;
	}

//	public String getTextViaBreak(int number) {
//        String result = switch (number) {
//            case 1:
//            case 2:
//                break "one or two"; 
//            case 3:
//                break "three";
//            case 4:
//            case 5:
//            case 6:
//                break "four or five or six";
//            default:
//                break "unknown";
//        };
//        return result;
//    }

}
