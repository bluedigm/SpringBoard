package com.bluedigm.springboard;

public class Useful {
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
