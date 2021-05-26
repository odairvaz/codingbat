package com.codingbat.array2;

import java.util.Arrays;

public class Exer01 {

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Return the number of even ints in the given array. Note: the % "mod" operator
	 * computes the remainder, e.g. 5 % 2 is 1.
	 * 
	 * countEvens([2, 1, 2, 3, 4]) â†’ 3 countEvens([2, 2, 0]) â†’ 3 countEvens([1, 3,
	 * 5]) â†’ 0
	 */
	public static int countEvens(int[] nums) {
		int evens = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0)
				evens++;
		}
		return evens;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array length 1 or more of ints, return the difference between the
	 * largest and smallest values in the array. Note: the built-in Math.min(v1, v2)
	 * and Math.max(v1, v2) methods return the smaller or larger of two values.
	 * 
	 * bigDiff([10, 3, 5, 6]) â†’ 7 bigDiff([7, 2, 10, 9]) â†’ 8 bigDiff([2, 10, 7, 2])
	 * â†’ 8
	 */
	public static int bigDiff(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		return max - min;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Return the "centered" average of an array of ints, which we'll say is the mean average of the values, 
	 * except ignoring the largest and smallest values in the array. If there are multiple copies of the 
	 * smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce 
	 * the final average. You may assume that the array is length 3 or more.
	 * 
	 * centeredAverage([1, 2, 3, 4, 100]) â†’ 3
	 * centeredAverage([1, 1, 5, 5, 10, 8, 7]) â†’ 5
	 * centeredAverage([-10, -4, -2, -4, -2, 0]) â†’ -3
	 */
	public static int centeredAverage(int[] nums) {
		int sum = 0;
		int min = nums[0];
		int max = nums[0];
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			sum += nums[i];
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		return (sum - min - max) / (len - 2);
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Return the sum of the numbers in the array, returning 0 for an empty array. 
	 * Except the number 13 is very unlucky, so it does not count and numbers that 
	 * come immediately after a 13 also do not count.
	 * 
	 * sum13([1, 2, 2, 1]) â†’ 6
	 * sum13([1, 1]) â†’ 2
	 * sum13([1, 2, 2, 1, 13]) â†’ 6
	 */
	public static int sum13(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 13)
				sum += nums[i];
			else
				i++;
		}
		return sum;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Return the sum of the numbers in the array, except ignore sections of numbers 
	 * starting with a 6 and extending to the next 7 
	 * (every 6 will be followed by at least one 7). Return 0 for no numbers.
	 * 
	 * sum67([1, 2, 2]) â†’ 5
	 * sum67([1, 2, 2, 6, 99, 99, 7]) â†’ 5
	 * sum67([1, 1, 6, 7, 2]) â†’ 4
	 */
	public static int sum67(int[] nums) {
		int sum = 0;
		boolean ignore = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 6)
				ignore = true;
			
			if (!ignore)
				sum += nums[i];
			
			if (nums[i] == 7 && ignore == true)
				ignore = false;
		}
		return sum;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
	 * 
	 * has22([1, 2, 2]) â†’ true
	 * has22([1, 2, 1, 2]) â†’ false
	 * has22([2, 1, 2]) â†’ false
	 */
	public static boolean has22(int[] nums) {
		if(nums.length < 2) return false;
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == 2 && nums[i + 1] == 2)
	            return true;
		}
		return false;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the array contains no 1's and no 3's.
	 * 
	 * lucky13([0, 2, 4]) â†’ true
	 * lucky13([1, 2, 3]) â†’ false
	 * lucky13([1, 2, 4]) â†’ false
	 */
	public boolean lucky13(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1 || nums[i] == 3 ) return false;
		}
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
	 * 
	 * sum28([2, 3, 2, 2, 4, 2]) â†’ true
	 * sum28([2, 3, 2, 2, 4, 2, 2]) â†’ false
	 * sum28([1, 2, 3, 4]) â†’ false
	 */
	public static boolean sum28(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 2) sum += nums[i];
		}
		return sum == 8;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the number of 1's is greater than the number of 4's
	 * 
	 * more14([1, 4, 1]) â†’ true
	 * more14([1, 4, 1, 4]) â†’ false
	 * more14([1, 1]) â†’ true
	 */
	public boolean more14(int[] nums) {
		int count1 = 0;
		int count4 = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) count1++;
			else if(nums[i] == 4) count4++;
		}
		return count1 > count4;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. 
	 * The given n may be 0, in which case just return a length 0 array. You do not need a separate 
	 * if-statement for the length-0 case; the for-loop should naturally execute 0 times in that case, 
	 * so it just works. The syntax to make a new int array is: new int[desired_length]   
	 * (See also: FizzBuzz Code)
	 * 
	 * fizzArray(4) â†’ [0, 1, 2, 3]
	 * fizzArray(1) â†’ [0]
	 * fizzArray(10) â†’ [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	 */
	public static int[] fizzArray(int n) {
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if every element is a 1 or a 4.
	 * 
	 * only14([1, 4, 1, 4]) â†’ true
	 * only14([1, 4, 2, 4]) â†’ false
	 * only14([1, 1]) â†’ true
	 */
	public static boolean only14(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 1 && nums[i] != 4)
				return false;
		}
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. 
	 * through n-1. N may be 0, in which case just return a length 0 array. 
	 * Note: String.valueOf(xxx) will make the String form of most types. 
	 * The syntax to make a new string array is: new String[desired_length]  
	 * (See also: FizzBuzz Code)
	 * 
	 * fizzArray2(4) â†’ ["0", "1", "2", "3"]
	 * fizzArray2(10) â†’ ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
	 * fizzArray2(2) â†’ ["0", "1"]
	 */
	public static String[] fizzArray2(int n) {
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = String.valueOf(i);
		}
		return res;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if it contains no 1's or it contains no 4's.
	 * 
	 * no14([1, 2, 3]) → true
	 * no14([1, 2, 3, 4]) → false
	 * no14([2, 3, 4]) → true
	 */
	public static boolean no14(int[] nums) {
		boolean has1 = false;
		boolean has4 = false;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) has1 = true;
			else if(nums[i] == 4) has4 = true;
		}
		return (!has1 || !has4);
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/* We'll say that a value is "everywhere" in an array if for every pair of 
	 * adjacent elements in the array, at least one of the pair is that value. 
	 * Return true if the given value is everywhere in the array.
	 * 1
	 * isEverywhere([1, 2, 1, 3], 1) → true
	 * isEverywhere([1, 2, 1, 3], 2) → false
	 * isEverywhere([1, 2, 1, 3, 4], 1) → false
	 */
	public static boolean isEverywhere(int[] nums, int val) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != val && nums[i + 1] != val)
				return false;
		}
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the array 
	 * contains a 2 next to a 2 or a 4 next to a 4, but not both.
	 * 
	 * either24([1, 2, 2]) → true
	 * either24([4, 4, 1]) → true
	 * either24([4, 4, 1, 2, 2]) → false
	 */
	public static boolean either24(int[] nums) {
		boolean has22 = false;
		boolean has44 = false;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 2 && nums[i + 1] == 2)
				has22 = true;

			if (nums[i] == 4 && nums[i + 1] == 4)
				has44 = true;
		}
		return has22 != has44;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given arrays nums1 and nums2 of the same length, for every element in nums1, 
	 * consider the corresponding element in nums2 (at the same index). 
	 * Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
	 * 
	 * matchUp([1, 2, 3], [2, 3, 10]) → 2
	 * matchUp([1, 2, 3], [2, 3, 5]) → 3
	 * matchUp([1, 2, 3], [2, 3, 3]) → 2
	 */
	public static int matchUp(int[] nums1, int[] nums2) {
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (Math.abs(nums1[i] - nums2[i]) <= 2 && nums1[i] != nums2[i])
				count++;
		}
		return count;
	}

	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the array contains two 7's next to each other, 
	 * or there are two 7's separated by one element, such as with {7, 1, 7}.
	 * 
	 * has77([1, 7, 7]) → true
	 * has77([1, 7, 1, 7]) → true
	 * has77([1, 7, 1, 1, 7]) → false
	 */
	public static boolean has77(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 7 && nums[i + 1] == 7)
				return true;
			if (i < nums.length - 2 && nums[i] == 7 && nums[i + 2] == 7)
				return true;
		}
		return false;
	}
	
	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
	 * 
	 * has12([1, 3, 2]) → true
	 * has12([3, 1, 2]) → true
	 * has12([3, 1, 4, 5, 2]) → true
	 */
	public static boolean has12(int[] nums) {
		boolean foundOne = false;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) foundOne = true;
			if(foundOne && nums[i] == 2) return true;
		}
		return false;
	}

	
	// ----------------------------------------------------------------------------------------------------------
	/*
	 * Given an array of ints, return true if the array contains either 
	 * 3 even or 3 odd values all next to each other.
	 * 
	 * modThree([2, 1, 3, 5]) → true
	 * modThree([2, 1, 2, 5]) → false
	 * modThree([2, 4, 2, 5]) → true
	 */
	public static boolean modThree(int[] nums) {
		if(nums.length < 3) return false;
		for (int i = 0; i < nums.length - 2; i++) {
			//if(nums[i] % 2 == nums[i+1] % 2 && nums[i] % 2 == nums[i+2] % 2) return true;
			if(nums[i] % 2 == 0 && nums[i+1] % 2 == 0 && nums[i+2] % 2 == 0 ) return true;
			if(nums[i] % 2 != 0 && nums[i+1] % 2 != 0 && nums[i+2] % 2 != 0 ) return true;
		}
		return false;
	}




	
	public static void main(String[] args) {
		int[] nums = {2, 4, 2, 5};
		System.out.println(modThree(nums));
	}

}
