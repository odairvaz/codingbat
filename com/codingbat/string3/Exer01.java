package com.codingbat.string3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Exer01 {

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and 
	 * the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). 
	 * We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. 
	 * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
	 * 
	 * countYZ("fez day") → 2
	 * countYZ("day fez") → 2
	 * countYZ("day fyyyz") → 2
	 */	
	public static int countYZ(String str) {
		int countXY = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'z' || str.charAt(i) == 'y') {
				if (i == str.length() - 1)
					countXY++;
				
				else if (i < str.length() - 1 && !Character.isLetter(str.charAt(i + 1)))
					countXY++;
			}
		}
		return countXY;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given two strings, base and remove, return a version of the base string where all 
	 * instances of the remove string have been removed (not case sensitive). 
	 * You may assume that the remove string is length 1 or more. 
	 * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
	 * 
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there"
	 * withoutString("This is a FISH", "IS") → "Th a FH"
	 */
	public static String withoutString(String base, String remove) {
		String result = "";
		int bLen = base.length();
		int rLen = remove.length();
		
		for(int i = 0; i < bLen; i++) {
			if(base.substring(i).toLowerCase().startsWith(remove.toLowerCase())) {
				i += rLen - 1;
			}
			else 
				result += base.charAt(i);
		}
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return true if the number of appearances of "is" anywhere in the string 
	 * is equal to the number of appearances of "not" anywhere in the string (case sensitive).
	 * 
	 * equalIsNot("This is not") → false
	 * equalIsNot("This is notnot") → true
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */
	public static boolean equalIsNot(String str) {
		int countIs = 0;
		int countNot = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.substring(i).startsWith("is")) {
				countIs++;
				i++;
			} else if (str.substring(i).startsWith("not")) {
				countNot++;
				i+=2;
			} 
		}
		return countIs == countNot;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. 
	 * Return true if all the g's in the given string are happy.
	 * 
	 * gHappy("xxggxx") → true
	 * gHappy("xxgxx") → false
	 * gHappy("xxggyygxx") → false
	 * gHappy("xxggyyxxg")
	 */
	public static boolean gHappy(String str) {
		if (str.length() == 1 && str.charAt(0) == 'g')
			return true;

		if (str.length() > 1 && str.charAt(str.length() - 1) == 'g' && str.charAt(str.length() - 2) != 'g')
			return false;

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'g' && str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g')
				return false;
		}
		return true;
	}
	
	public boolean gHappy_(String str) {
		int len = str.length();
		boolean happy = true;

		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'g') {
				if (i > 0 && str.charAt(i - 1) == 'g')
					happy = true;
				else if (i < len - 1 && str.charAt(i + 1) == 'g')
					happy = true;
				else
					happy = false;
			}
		}
		return happy;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * We'll say that a "triple" in a string is a char appearing three times in a row. 
	 * Return the number of triples in the given string. The triples may overlap.
	 * 
	 * countTriple("abcXXXXabc") → 1
	 * countTriple("xxxabyyyycd") → 3
	 * countTriple("a") → 0
	 */
	public static int countTriple(String str) {
		int countTriple = 0;
		for(int i = 0; i < str.length() - 2; i++) {
			if(str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) 
				countTriple++;
		}
		return countTriple;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. 
	 * 7Return 0 if there are no digits in the string. (Note: Character.isDigit(char) 
	 * tests if a char is one of the chars '0', '1', .. '9'. 
	 * Integer.parseInt(string) converts a string to an int.)
	 * 
	 * sumDigits("aa1bc2d3") → 6
	 * sumDigits("aa11b33") → 8
	 * sumDigits("Chocolate") → 0
	 */
	public static int sumDigits(String str) {
		int sumChars = 0;
		for(int i = 0; i < str.length(); i++ ) {
			if(Character.isDigit(str.charAt(i)))
				sumChars += Integer.parseInt(Character.toString(str.charAt(i)));
		}
		return sumChars;
	}

	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return the longest substring that appears at both the beginning 
	 * and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
	 * 
	 * sameEnds("abXYab") → "ab"
	 * sameEnds("xx") → "x"
	 * sameEnds("xxx") → "x"
	 */
	
	public static String sameEnds(String string) {
		String result = "";
		for (int i = 0; i < string.length() / 2 + 1; i++) {
			if (string.substring(0, i).equals(string.substring(string.length() - i)))
				result = string.substring(0, i);
		}
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, look for a mirror image (backwards) string at both the beginning and 
	 * end of the given string. In other words, zero or more characters at the very 
	 * begining of the given string, and at the very end of the string in reverse order 
	 * (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
	 * 
	 * mirrorEnds("abXYZba") → "ab"
	 * mirrorEnds("abca") → "a"
	 * mirrorEnds("aba") → "aba"
	 */
	public static String mirrorEnds(String str) {
		if(str.length() < 2 ) return str;
		String result = "";		
		
		for(int i = 0; i < str.length() ; i++) {
			if(str.charAt(i) == str.charAt(str.length() - 1 - i))
				result += str.charAt(i);
			else 
				break;
		}
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return the length of the largest "block" in the string. 
	 * A block is a run of adjacent chars that are the same.
	 * 
	 * maxBlock("hoopla") → 2
	 * maxBlock("abbCCCddBBBxx") → 3
	 * maxBlock("") → 0
	 */
	public static int maxBlock(String str) {
		
		if (str.length() == 0)
			return 0;
		
		int len = str.length();
		int maxBlock = 0;
		int currentBlock = 1;

		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1))
				currentBlock++;
			else
				currentBlock = 1;

			if (currentBlock > maxBlock)
				maxBlock = currentBlock;
		}
		return maxBlock;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. 
	 * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) 
	 * tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
	 * 
	 * sumNumbers("abc123xyz") → 123
	 * sumNumbers("aa11b33") → 44
	 * sumNumbers("7 11") → 18
	 */
	public int sumNumbers(String str) {
		int len = str.length();
		int sum = 0;
		String tmp = "";

		for (int i = 0; i < len; i++) {
			if (Character.isDigit(str.charAt(i))) {
				if (i < len - 1 && Character.isDigit(str.charAt(i + 1))) {
					tmp += str.charAt(i);
				} else {
					tmp += str.charAt(i);
					sum += Integer.parseInt(tmp);
					tmp = "";
				}
			}
		}
		return sum;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, return a string where every appearance of the lowercase word "is" 
	 * has been replaced with "is not". The word "is" should not be immediately preceeded 
	 * or followed by a letter -- so for example the "is" in "this" does not count. 
	 * (Note: Character.isLetter(char) tests if a char is a letter.)
	 * 
	 * notReplace("is test") → "is not test"
	 * notReplace("is-is") → "is not-is not"
	 * notReplace("This is right") → "This is not right"
	 */
	public static String notReplace(String str) {
		String result = "";
		str = " " + str + " ";
		for (int i = 0; i < str.length(); i++) {//i = 7
			if(str.substring(i).startsWith("is") && !Character.isLetter(i-1) && !Character.isLetter(str.charAt(i + 2))) {
				result += "is not"; //is not-
				i++;
			}
			else
				result += str.substring(i, i+1);
		}
		return result;
	}
	
	public static String notReplace_(String str) {
		String result = "";
		int len = str.length();

		for (int i = 0; i < len; i++) {
			if (i - 1 >= 0 && Character.isLetter(str.charAt(i - 1))
					|| i + 2 < len && Character.isLetter(str.charAt(i + 2))) {
				result += str.charAt(i);
			} else if (i + 1 < len && str.substring(i, i + 2).equals("is")) {
				result += "is not";
				i++;
			} else
				result += str.charAt(i);
		}
		return result;
	}
	

	
	public static void main(String[] args) {
		System.out.println(notReplace_("is test"));
	}

}
