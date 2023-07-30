package DataStructure.Array._矩阵问题;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/diagonal-traverse/
 * @date 2022/6/149:42 AM
 */
public class Diagonal_Traverse {

    // 对角线遍历矩阵
    //Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [1,2,4,7,5,3,6,8,9]
    // 1 , 2 , 3
    // 4 , 5 , 6
    // 7 , 8 , 9
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[]{};
        int raw = mat.length  , col = mat[0].length;

        int[] res = new int[raw * col];
        int r = 0 , c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            if ((r + c) % 2 == 0){  // 横纵坐标之和为偶数，说明往上遍历
                if (c == col-1) r++;            // 注意这里判断，往上遍历，一定是先到 col-1


                else  if (r == 0) c++;
                else {
                   r--;         // 注意这里的移动方向！！！！
                   c++;
                }
            }else { // 横纵坐标之和为奇数，说明往下遍历
                if (r == raw-1) c++;
                else if (c == 0) r++;
                else{
                    c--;
                    r++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1 , 2 , 3} , {4 , 5 , 6} , {7 , 8 ,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

    }
}
