package Algorithm.dfs._岛屿问题;

// https://leetcode.cn/problems/max-area-of-island/
public class _695岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) res = Math.max(res , dfs(i , j , grid));
            }
        }
        return res;

    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;
        int count = 1;
        grid[i][j] = 2;
        return count + dfs(i+1 , j , grid) + dfs(i-1, j , grid) + dfs(i,j+1,  grid) + dfs(i , j-1 , grid);
    }
}
