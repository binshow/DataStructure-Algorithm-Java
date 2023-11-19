package Algorithm.dfs._岛屿问题;


import org.junit.jupiter.api.Test;

// https://leetcode.cn/problems/number-of-enclaves/description/
public class _1020_飞地的数量 {



    //给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
    //
    //一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
    //
    //返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
    //输出：3
    //解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
    //示例 2：
    //
    //
    //输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
    //输出：0
    //解释：所有 1 都在边界上或可以到达边界。


    @Test
    void test(){

    }


    /*
    * 思路1：从边界的1开始进行 dfs，将相邻的1全部变成0，最后剩下的1的数量就是答案
    *
    * */
    public int numEnclaves(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(grid , i , 0);
            if (grid[i][n-1] == 1) dfs(grid , i , n-1);
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(grid , 0 , i);
            if (grid[m-1][i] == 1) dfs(grid , m-1 , i);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid , i+1 , j);
        dfs(grid , i-1 , j);
        dfs(grid , i , j+1);
        dfs(grid , i , j-1);
    }

}
