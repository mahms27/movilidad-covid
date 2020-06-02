package net.javaguides.springboot.springsecurity.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {


	private Utils() {
		throw new IllegalStateException("Utility class");
  	}
	
	public static String getLoggedUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		return userName;
	}
}
