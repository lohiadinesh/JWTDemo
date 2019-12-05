package com.mycompany.caas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		final BCryptPasswordEncoder en = new BCryptPasswordEncoder();
    	System.out.println(en.encode("mycompany"));
	}

}
