package com.codingbat.ap1;

public class Exer01 {

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of scores, return true if each score is equal or 
	 * greater than the one before. The array will be length 2 or more.
	 * 
	 * scoresIncreasing([1, 3, 4]) → true
	 * scoresIncreasing([1, 3, 2]) → false
	 * scoresIncreasing([1, 1, 4]) → true
	 */
	public static boolean scoresIncreasing(int[] scores) {
		for (int i = 0; i < scores.length - 1; i++) {
			if (scores[i] > scores[i + 1])
				return false;
		}
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of scores, return true if there are scores of 100 
	 * next to each other in the array. The array length will be at least 2.
	 * 
	 * scores100([1, 100, 100]) → true
	 * scores100([1, 100, 99, 100]) → false
	 * scores100([100, 1, 100, 100]) → true
	 */
	public static boolean scores100(int[] scores) {
		for (int i = 0; i < scores.length - 1; i++) {
			if (scores[i] == 100 && scores[i + 1] == 100)
				return true;
		}
		return false;
	}


	
	public static void main(String[] args) {
		int[] nums = {100, 1, 100, 100};
		System.out.println(scores100(nums));
	}
	
	
}
