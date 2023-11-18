package Algorithm.topological_sort;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/
public class _329_longest_increasing_path_in_matrix {



    // 简单解法： 以每个点为起点找最长路径 ---> 超时
   /* public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length , n = matrix[0].length;
        int res = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                res = Math.max(res , dfs(matrix , i , j , Integer.MIN_VALUE));
            }
        }
        return res;
    }

    int dfs(int[][] matrix , int i , int j , int cur){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;

        if(matrix[i][j] <= cur) return 0;


        int a = dfs(matrix , i+1 , j , matrix[i][j]);
        int b = dfs(matrix , i-1 , j , matrix[i][j]);
        int c = dfs(matrix , i , j+1 , matrix[i][j]);
        int d = dfs(matrix , i , j-1 , matrix[i][j]);

        return 1 + Math.max(Math.max(a , b) , Math.max(c , d));
    }*/




    // 加速查找： 记忆化搜索
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        // 记录 以 matrix[i][j] 开头的是否已经被计算了
        int[][] isv = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res , dfs(matrix , i , j , Integer.MIN_VALUE, isv));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int cur, int[][] isv) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if (matrix[i][j] <= cur) return 0;
        if (isv[i][j] != 0) return isv[i][j];
        int a = dfs(matrix , i + 1 , j , matrix[i][j] , isv);
        int b = dfs(matrix , i - 1 , j , matrix[i][j] , isv);
        int c = dfs(matrix , i  , j + 1 , matrix[i][j] , isv);
        int d = dfs(matrix , i  , j - 1 , matrix[i][j] , isv);
        int res = 1 + Math.max(Math.max(a , b) , Math.max(c , d));
        isv[i][j] = res;
        return res;
    }



    // 拓扑排序 + bfs
    // 以矩阵中的最大点（比相邻元素都大）作为起点，往外扩散，最远的就是 最长递增路径
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPathV2(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int[][] outDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs){
                    int x = i + dir[0] , y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                        outDegree[i][j]++;
                    }
                }
            }
        }

        for (int[] tmo : outDegree) System.out.println(Arrays.toString(tmo));

        // 出度为0的全部入队
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outDegree[i][j] == 0) queue.add(new int[]{i , j});
            }
        }

        int res = 0; // 记录扩散步长
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[cur[0]][cur[1]]){
                        outDegree[x][y]--;
                        if (outDegree[x][y] == 0) queue.add(new int[]{x , y});
                    }
                }
            }
            res++;
        }
        return res;
    }


}
