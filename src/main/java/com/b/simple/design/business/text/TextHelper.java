package com.b.simple.design.business.text;


public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		int strLength = str.length();
		if(strLength <2) return str;
		char lastChar = str.charAt(strLength-1);
		char secondLastChar = str.charAt(strLength-2);
		String startingString = str.substring(0, strLength -2);
		String finalstring = startingString + lastChar + secondLastChar;
		return finalstring;
	}


	public String truncateAInFirst2Positions(String str) {
		int strLen = str.length();
		if(strLen <= 2) {
			return str.replaceAll("A","");
		}
		String first2characters = str.substring(0,2);
		String remainingStr = str.substring(2);
		return first2characters.replaceAll("A","") + remainingStr;
	}
}
