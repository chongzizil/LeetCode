package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/28.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            } else if (digits[i] == 9 && i != 0) {
                digits[i] = 0;
            } else {
                digits[i] = 0;

                int newDigits[] = new int[n + 1];
                newDigits[0] = 1;

                for (int j = 0; j < n; j++) {
                    newDigits[j + 1] = digits[j];
                }
                return newDigits;
            }
        }

        return digits;
    }
}
