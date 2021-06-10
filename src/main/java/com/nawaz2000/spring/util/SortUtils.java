package com.nawaz2000.spring.util;

public class SortUtils {
	
	public static int FIRST_NAME = 1;
	public static int LAST_NAME = 2;
	public static int EMAIL = 3;
	
	public static void updateFirstName() {
		if (FIRST_NAME == 1) {
			FIRST_NAME*=10;
		}else {
			FIRST_NAME/=10;
		}
		
	}
	
	public static void updateLastName() {
		if (LAST_NAME == 2)
			LAST_NAME*=10;
		else
			LAST_NAME/=10;
	}
	
	public static void updateEmail() {
		if (EMAIL == 3)
			EMAIL*=10;
		else
			EMAIL/=10;
	}

	public static void update() {
		if(FIRST_NAME == 1) {
			FIRST_NAME*=10;
			LAST_NAME*=10;
			EMAIL*=10;
		}else {
			FIRST_NAME/=10;
			LAST_NAME/=10;
			EMAIL/=10;
		}
		
	}
	
}
