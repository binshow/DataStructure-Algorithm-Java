package Algorithm.binarySearch.matrixSearch;

public class _74Search2DMatrix {



    /*
    * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 Output: true
    * */

    // 从右上角出发
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;
        if (n == 0) return false;
        int i = 0 , j = n - 1;
        while (i < m && j >= 0){
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return true;
        }
        return false;
    }

}
