package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zil on 2014/7/29.
 */
public class Permutations {
    List<List<Integer>> res;
    List<Integer> permutation;
    boolean[] isOccupied;

    public List<List<Integer>> permute(int[] num) {
        res = new ArrayList<List<Integer>>();
        permutation = new ArrayList<Integer>();
        isOccupied = new boolean[num.length];

        calculatePermutation(0, num);

        return res;
    }

    public void calculatePermutation(int index, int[] num) {
        if(index == num.length) {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }

        for(int i = 0; i < num.length; i++) {
            if(!isOccupied[i]) {
                permutation.add(num[i]);
                isOccupied[i] = true;
                calculatePermutation(index + 1, num);
                permutation.remove(index);
                isOccupied[i] = false;
            }
        }
    }
}
