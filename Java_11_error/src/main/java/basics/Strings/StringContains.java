/**
 *
 */
package basics.Strings;

/**
 * @author Office
 *
 */
public class StringContains {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

//    // “最好的方法”，时间复杂度O(n + m)，空间复杂度O(1)
//    Boolean StringContain(String[] a, String[] b) {
//	int hash = 0;
//	for (int i = 0; i < a.length; ++i) {
//	    hash |= (1 << (a[i] - 'A'));
//	}
//	for (int i = 0; i < b.length; ++i) {
//	    if ((hash & (1 << (b[i] - 'A'))) == 0) {
//		return false;
//	    }
//	}
//	return true;
//    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
	if (str == null || searchStr == null)
	    return false;

	final int length = searchStr.length();
	if (length == 0)
	    return true;

	for (int i = str.length() - length; i >= 0; i--) {
	    if (str.regionMatches(true, i, searchStr, 0, length))
		return true;
	}
	return false;
    }
}
