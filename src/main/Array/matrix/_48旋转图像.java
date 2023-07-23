package Array.matrix;

import java.util.Arrays;

public class _48旋转图像 {

    // https://leetcode.cn/problems/rotate-image/


    // 1 2 3        7 4 1
    // 4 5 6        8 5 2
    // 7 8 9        9 6 3

    public static void rotate(int[][] matrix) {

        // 先轴对称
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m  ; i++) {
            for (int j = i; j < n; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }

       // for(int[] num : matrix) System.out.println(Arrays.toString(num));
       // System.out.println("=====");

        // 再 左右对称
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[i][n - j-1];
                matrix[i][n-j-1] = tem;
            }
        }
       // for(int[] num : matrix) System.out.println(Arrays.toString(num));

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);

    }
}
