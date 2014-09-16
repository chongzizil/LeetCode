package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zil on 2014/9/12.
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int size = S.length;

		Arrays.sort(S);

		res.add(new ArrayList<Integer>());

		if (S.length == 0) {
			return res;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < S.length; j++) {
				List<Integer> comb = new ArrayList<Integer>();
				comb.add(S[j]);
				helper1(S, j + 1, i, comb, res);
			}
		}

		return res;
	}

	public void helper1(int[] S, int start, int size, List<Integer> comb, List<List<Integer>> res) {
		if (size == 0) {
			res.add(comb);
			return;
		}

		for (int i = start; i < S.length; i++) {
			if (!comb.contains(S[i])) {
				List<Integer> newComb = new ArrayList<Integer>(comb);
				newComb.add(S[i]);
				helper1(S, i, size - 1, new ArrayList<Integer>(newComb), res);
			}
		}
	}
	/////////////////////////////////////////////////////////
	public List<List<Integer>> subsets2(int[] S) {

		Arrays.sort(S);

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int size = S.length;

		res.add(new ArrayList<Integer>());

		if (S.length == 0) {
			return res;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < S.length; j++) {
				List<Integer> comb = new ArrayList<Integer>();
				comb.add(S[j]);
				helper(S, j + 1, i, comb, res);
			}
		}

		return res;
	}

	public static void helper(int[] S, int start, int size, List<Integer> comb, List<List<Integer>> res) {
		if (size == 0) {
			res.add(comb);
			return;
		}

		for (int i = start; i < S.length; i++) {
			if (!comb.contains(S[i])) {
				List<Integer> newComb = new ArrayList<Integer>(comb);
				newComb.add(S[i]);
				helper(S, i, size - 1, new ArrayList<Integer>(newComb), res);
			}
		}
	}

	/**
	 * This is actually a brilliant solution. Consider for an array A, we have all its subsets denote
	 * as S_A. If we add one element to that array and have B, and let S_B be B's subsets. Then
	 * S_x as the newly added subsets are equals to S_B - S_A. In this solution, we simple add the
	 * new element to every subset of A which is S_A and we will have S_x.....
	 */
	public List<List<Integer>> subsets1(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int size = S.length;

		Arrays.sort(S);

		res.add(new ArrayList<Integer>());

		for (int i = 0; i < size; i++) {
			int curr_size = res.size();
			for (int j = 0; j < curr_size; j++) {
				List<Integer> tmp = new ArrayList<Integer>(res.get(j));
				tmp.add(S[i]);
				res.add(tmp);
			}
		}

		return res;
	}
}
