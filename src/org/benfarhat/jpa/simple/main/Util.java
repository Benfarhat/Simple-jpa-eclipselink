package org.benfarhat.jpa.simple.main;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {

	public static String generateName() {
		int length = 7;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    
	    System.out.println(generatedString);
	    
	    return generatedString;
	}
	
	public static String generateName(int length, boolean useLetters, boolean useNumbers) {

	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    
	    System.out.println(generatedString);
	    
	    return generatedString;
	}

	public static int generatePrice() {
		int min = 10000;
		int max = 90000;
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
	
	public static int generatePrice(int min, int max) {
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
}
