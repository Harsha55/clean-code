package com.b.simple.design.business.text;


public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		char lastChar = str.charAt(-1);
		char secondLastChar = str.charAt(-1);
		String startingString = str.substring(0,str.length()-2);
		String finalstring = startingString + lastChar + secondLastChar;
		return finalstring;
	}

	private String getReverseStr(String str, int strLen) {
		String reverseStr;
		reverseStr = (str.substring(strLen -1) + str.substring(strLen - 2, strLen -1));
		return reverseStr;
	}

	public String truncateAInFirst2Positions(String str) {
		return null;
	}
}
