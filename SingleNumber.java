public class Solution {
    public int singleNumber(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int singleNum = A[0];
        for(int i = 1; i < A.length; i++) {
            singleNum ^= A[i];
        }
        return singleNum;
    }
}