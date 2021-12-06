package com.b.simple.design.business.text;


public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		String reverseStr;
		int strLen = str.length();
		if (strLen < 2) return str;
		else if ( strLen == 2){
			reverseStr = getReverseStr(str, strLen);
			return reverseStr;
		}
		else{
			reverseStr = str.substring(0,strLen - 2);
			reverseStr += getReverseStr(str, strLen);
		}
		return reverseStr;
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
