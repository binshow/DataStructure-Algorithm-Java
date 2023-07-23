package Array.matrix;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/set-matrix-zeroes/
public class _73矩阵置0 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        Set<Integer> raw = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i = 0 ; i < m ; i++){
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    raw.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
           for (int j = 0 ; j < n ; j++){
               if (raw.contains(i) || col.contains(j)) matrix[i][j] = 0;
           }
        }
    }
}
