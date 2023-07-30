package DataStructure.Array._矩阵问题;

import java.util.ArrayList;
import java.util.List;

public class _54_59螺旋矩阵 {


    //https://leetcode.cn/problems/spiral-matrix/
    // 顺时针旋转矩阵

    // 1 2 3
    // 4 5 6
    // 7 8 9
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) return res;
        int l = 0 , r = n-1;
        int t = 0 , d = m-1;
        while (true){
            for(int i = l ; i <= r ; i++) res.add(matrix[t][i]);
            if (++t > d) break;
            for(int i = t ; i <= d ; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            for(int i = r ; i >= l ; i--) res.add(matrix[d][i]);
            if (--d < t) break;
            for(int i = d ; i >= t ; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }

        return res;
    }

    // https://leetcode.cn/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int l = 0 , r = n-1;
        int t = 0 , d = n-1;
        int index = 1;
        while(true){
            for(int i = l ; i <= r ; i++) res[t][i] = index++;
            if(++t > d) break;

            for(int i = t ; i <= d ; i++) res[i][r] = index++;
            if(--r < l ) break;

            for(int i = r ; i >= l ; i--) res[d][i] = index++;
            if(--d < t) break;

            for(int i = d ; i >= t ; i--) res[i][l] = index++;
            if(++l > r) break;
        }

        return res;

    }
}
