package com.li.zil.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * One brutal solution is to use double for loop iteratively search the array whose running time is
 * O(n^2).
 *
 * Another solution is to sort the array first, then set two pointers of both side and get the
 * result, the space complexity is O(1) though the running time is O(nlogn). And need a way to
 * keep the original indices...
 *
 * The best solution is to use a hash map. We store the key as the number need to found for a
 * specific number and the value as the specific number's index.
 */
public class TwoSum {
	// This is a O(n) solution, consider the get operation of HashMap of Java is O(1). (ContainsKey is
	// just get operation without retrieve the result...)
	public int[] twoSum(int[] numbers, int target) {
		// I store the needed number of the an element as key and the indice of that element as value.
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int[] res = new int[2];

		// Just travers the array
		for (int i = 0; i < numbers.length; i++) {
			int numberToFind = target - numbers[i];
			// If the number to find exists in the hash map, retrieve it's indice and return the result :)
			if (hashMap.containsKey(numberToFind)) {
				int index = hashMap.get(numberToFind);
				return new int[]{index + 1, i + 1};
			}

			// If the number to find does not exist in the hash map, then put the number and the element's
			// indice into  the hash map.
			hashMap.put(numbers[i], i);
		}

		// This should not happen. Since exactly one solution is required.
		throw new Error("This should not happen...");
	}
}
