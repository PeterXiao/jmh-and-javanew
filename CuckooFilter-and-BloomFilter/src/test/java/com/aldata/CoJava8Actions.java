/**
 * 
 */
package com.aldata;

/**
 * @author xiaoy
 *
 */
public class CoJava8Actions {

	/**
	 * 
	 */
	public CoJava8Actions() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Thread(()->{System.out.println(123)});
		System.out.println(" 123 s");
		String code = (Math.random() + "").substring(2, 8);
		
		String codes = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10,5)));
		
		
		
		System.out.println(codes);
		
	}
	 class AgeUtils {
	    public boolean isChild(int age) {
	        if (age >= 2 && age < 18) {
	            return true;
	        }
	        return false;
	    }
	}
}
