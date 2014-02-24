public class Solution {
    private int numTreesHelper(int n) {
        int[] numTreesOfNum = new int[n+1];
        numTreesOfNum[0] = 1;
        
        if (n < 0) {
            return 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                numTreesOfNum[i] += numTreesOfNum[j] * numTreesOfNum[i - j - 1];
            }
        }
        return numTreesOfNum[n];
    }
    
    public int numTrees(int n) {
        return numTreesHelper(n);
    }
}