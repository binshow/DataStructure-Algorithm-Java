package Algorithm.binarySearch.matrixSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _378KthSmallestElement {

    //Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
    //
    //Note that it is the kth smallest element in the sorted order, not the kth distinct element.
    //
    //You must find a solution with a memory complexity better than O(n2).



    @Test
    void test(){
        //[1,5,9],[10,11,13],[12,13,15]
        Assertions.assertEquals( kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}} , 8) , 13);
        Assertions.assertEquals( kthSmallest(new int[][]{{-5}} , 1) , -5);
    }


    // 1  5  9
    // 10 11 13
    // 12 13 15

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0] , r = matrix[n-1][n-1];
        while (l < r){
            int mid = l + r >> 1;
            // 一维映射成二维坐标
            if (check(matrix , mid, k)) r = mid;
            else l = mid + 1;
        }
        return l; // l 为什么能保证 在 matrix 中，因为  check  函数中用了 <=
    }

    // 判断 matrix 中小于 matrix[i][j] 的值是否 >= k
    private boolean check(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= mid) count++;
            }
        }
        return count >= k;
    }


}
