public class Solution {
    public int reverse(int x) {
        int reverseNum = 0;
        boolean isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = -x;
        }
        while (x > 0) {
            reverseNum = x % 10 + reverseNum * 10;
            x /= 10;
        }
        return isPositive ? reverseNum : -reverseNum;
    }
}