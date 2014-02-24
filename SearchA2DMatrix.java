package leetcode_java;

public class Search_A_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        while (start <= end) {
        	int mid = start + (end - start) / 2;
        	int i = mid / column;
        	int j = mid % column;
        	if (target == matrix[i][j]) {
        		return true;
        	}
        	else if (target > matrix[i][j]) {
        		start = mid + 1;
        	}
        	else {
        		end = mid - 1;
        	}
        }
        return false;
    }
}
