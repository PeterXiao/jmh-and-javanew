/**
 * 
 */
package com.recompiling;

/**
 * @author xiaoy
 *
 */
public class ConTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = s2.intern();
        System.err.println(s1==s2);
        System.err.println(s2==s3);
        
        
        System.err.println("*********************************************");
        
        System.err.println(s1==s3);
        
        System.err.println("*********************************************");
        StringBuilder sb = new StringBuilder();
        sb.append("llo");
        String s4 = sb.toString().intern();
        System.err.println("llo".equals(s4));

        Integer a = 127;
        Integer b = 127;

        Integer a1 = 128;
        Integer b1 = 128;

        @SuppressWarnings("deprecation")
		Integer a2 = new Integer(127);
        @SuppressWarnings("deprecation")
		Integer b2 = new Integer(127);
        System.err.println(a==b);
        
        System.err.println("*********************************************");
        
        
        System.err.println(a1==b1);
        System.err.println(a2==b2);


	}

}
