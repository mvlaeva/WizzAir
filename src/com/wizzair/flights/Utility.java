package com.wizzair.flights;

public abstract class Utility {
	
	static boolean isValidString(String string) {
		if (string != null && string.trim().length() > 0) {
			return true;
		}
		return false;
	}
}
