package com.codingbat.string2;

import java.util.Arrays;

public class Exer01 {
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given two strings, word and a separator sep, return a big string made of
	 * count occurrences of the word, separated by the separator string.
	 * 
	 * repeatSeparator("Word", "X", 3) → "WordXWordXWord" repeatSeparator("This",
	 * "And", 2) → "ThisAndThis" repeatSeparator("This", "And", 1) → "This"
	 */
	public static String repeatSeparator(String word, String sep, int count) {
		if (count == 0)
			return "";
		String result = word;
		for (int i = 1; i < count; i++)
			result = result + sep + word;
		return result;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, consider the prefix string made of the first N chars of the
	 * string. Does that prefix string appear somewhere else in the string? Assume
	 * that the string is not empty and that N is in the range 1..str.length().
	 * 
	 * prefixAgain("abXYabc", 1) → true prefixAgain("abXYabc", 2) → true
	 * prefixAgain("abXYabc", 3) → false
	 */
	public static boolean prefixAgain(String str, int n) {
		String prefix = str.substring(0, n);
		int prefixLen = prefix.length();
		if (prefixLen > (str.length() / 2))
			return false;

		for (int i = prefixLen; i <= str.length() - prefixLen; i++)
			if (str.substring(i, n + i).equals(prefix))
				return true;

		return false;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, does "xyz" appear in the middle of the string? To define
	 * middle, we'll say that the number of chars to the left and right of the "xyz"
	 * must differ by at most one. This problem is harder than it looks.
	 * 
	 * xyzMiddle("AAxyzBB") → true xyzMiddle("AxyzBB") → true xyzMiddle("AxyzBBB") →
	 * false
	 */
	public static boolean xyzMiddle(String str) {
		if(str.length() < 3) return false;
		int s1 = str.length() / 2 - 2;
		int s2 = str.length() / 2 - 1;
		
		if(str.length() % 2 == 0) {
			return str.substring(s1, s1 + 3).equals("xyz") || 
					str.substring(s2, s2 + 3).equals("xyz");
		}
		return str.substring(s2, s2 + 3).equals("xyz");
	}
	

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * 
	 */
	public static int getClosestToZero(int[] a) {
		int currentValue = 0;
		int closestVal = a[0];
		Arrays.sort(a);

		for (int index = 0; index < a.length; index++) {
			currentValue = a[index] * a[index];
			if (currentValue <= (closestVal * closestVal)) {
				closestVal = a[index];
			}
		}
		return closestVal;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	* A sandwich is two pieces of bread with something in between. 
	* Return the string that is between the first and last appearance of "bread" in the given string, 
	* or return the empty string "" if there are not two pieces of bread.
	* 
	* getSandwich("breadjambread") → "jam"
	* getSandwich("xxbreadjambreadyy") → "jam"
	* getSandwich("xxbreadyy") → ""
	*/
	public static String getSandwich(String str) {
		int firstIdxBread = str.indexOf("bread");
		int lastIdxBread = str.lastIndexOf("bread");
		
		if(firstIdxBread < 0 || lastIdxBread < 0 || firstIdxBread == lastIdxBread)
			return "";
		return str.substring(firstIdxBread + 5, lastIdxBread);
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Returns true if for every '*' (star) in the string, if there are chars 
	 * both immediately before and after the star, they are the same.
	 * 
	 * sameStarChar("xy*yzz") → true
	 * sameStarChar("xy*zzz") → false
	 * sameStarChar("*xa*az") → true
	 */
	public static boolean sameStarChar(String str) {
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*') {
				if (str.charAt(i - 1) != str.charAt(i + 1))
					return false;
			}
		}
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string, compute a new string by moving the first char to come after the next two chars, 
	 * so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, 
	 * so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
	 * 
	 * oneTwo("abc") → "bca"
	 * oneTwo("tca") → "cat"
	 * oneTwo("tcagdo") → "catdog"
	 */
	public static String oneTwo(String str) {
		if(str.length() < 3) return "";
		String result = "";
		for(int i = 0; i < str.length() - 3; i += 3)
			result += str.substring(i+1, i+3) + str.charAt(i);
		
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/* Look for patterns like "zip" and "zap" in the string -- length-3, 
	 * starting with 'z' and ending with 'p'. Return a string where for all such words, 
	 * the middle letter is gone, so "zipXzap" yields "zpXzp".
	 * 
	 * zipZap("zipXzap") → "zpXzp"
	 * zipZap("zopzop") → "zpzp"
	 * zipZap("zzzopzop") → "zzzpzp"
	 */
	public static String zipZap(String str) {
		if(str.length() < 3) return str;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
				result += str.substring(i, i + 1) + str.substring(i + 2, i + 3);
				i += 2;
			}			
			else
				result += str.substring(i, i + 1);
		}
		return result;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Return a version of the given string, where for every star (*) in the string the star and
	 * the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
	 * 
	 * starOut("ab*cd") → "ad"
	 * starOut("ab**cd") → "ad"
	 * starOut("sm*eilly") → "silly"
	 */
	public static String starOut(String str) {
		int len = str.length();
		String finalString = "";
		
		for (int i = 0; i < len; i++) {
			if (i == 0 && str.charAt(i) != '*')
				finalString += str.charAt(i);
			if (i > 0 && str.charAt(i) != '*' && str.charAt(i-1) != '*')
				finalString += str.charAt(i);
			if (i > 0 && str.charAt(i) == '*' && str.charAt(i-1) != '*')
				finalString = finalString.substring(0,finalString.length()-1);
		}
		return finalString;
	}
	
	public static String starOut2(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*')
				continue;
			if (i > 0 && s.charAt(i - 1) == '*')
				continue;
			if (i < s.length() - 1 && s.charAt(i + 1) == '*')
				continue;

			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string and a non-empty word string, return a version of the original String where 
	 * all chars have been replaced by pluses ("+"), 
	 * except for appearances of the word string which are preserved unchanged.
	 * 
	 * plusOut("12xy34", "xy") → "++xy++"
	 * plusOut("12xy34", "1") → "1+++++"
	 * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
	 */
	public static String plusOut(String str, String word) {
		String result = "";
		/*int i = 0;

		while (i < str.length()) {
			if (str.substring(i).startsWith(word)) {
				result = result + word;
				i = i + word.length();
			} else {
				result = result + "+";
				i++;
			}
		}*/
		
		for (int j = 0; j < str.length(); j++) {
			if (str.substring(j).startsWith(word)) {
				result = result + word;
				j =  j + word.length() - 1;
			} else {
				result = result + "+";
			}
		}
		return result;
	}
	
	public static String plusOut2(String str, String word) {
		int slen = str.length();
		int wlen = word.length();
		String fin = "";

		for (int i = 0; i < slen; i++) {
			if (i <= slen - wlen) {
				String tmp = str.substring(i, i + wlen);
				if (tmp.equals(word)) {
					fin += word;
					i += wlen - 1;
				} else
					fin += "+";
			} else
				fin += "+";
		}
		return fin;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a string and a non-empty word string, return a string made of each char just before and 
	 * just after every appearance of the word in the string. Ignore cases where there is no char 
	 * before or after the word, and a char may be included twice if it is between two words.
	 * 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i"
	 * wordEnds("XY123XY", "XY") → "13"
	 * wordEnds("XY1XY", "XY") → "11"
	 */
	public static String wordEnds(String str, String word) {
		String result = "";
		int wlen = word.length();
		int slen = str.length();

		for (int i = 0; i <= slen - wlen; i++) {
			if (str.substring(i, i + wlen).equals(word)) {
				if (i > 0)
					result = result + str.charAt(i - 1);
				if (i < slen - wlen)
					result = result + str.charAt(i + wlen);
			}
		}
		return result;
	}




	public static void main(String[] args) {

		System.out.println("\uD83D\uDE00");
		
	}


}
