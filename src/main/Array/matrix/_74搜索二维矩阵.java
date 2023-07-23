package Array.matrix;

// https://leetcode.cn/problems/search-a-2d-matrix/
public class _74搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int l = 0 , r = n-1;
        while (r >= 0 && l < m ){
            if (matrix[l][r] > target) r--;
            else if (matrix[l][r] < target) l++;
            else return true;
        }
        return false;
    }

}
