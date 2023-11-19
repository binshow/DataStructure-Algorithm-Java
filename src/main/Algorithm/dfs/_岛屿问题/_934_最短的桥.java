package Algorithm.dfs._岛屿问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/shortest-bridge/
public class _934_最短的桥 {


    //给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
    //
    //岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
    //
    //你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
    //
    //返回必须翻转的 0 的最小数目。


    @Test
    void test(){
        Assertions.assertEquals(shortestBridge(new int[][]{
                {0,1},
                {1,0}
        }) , 1);

        Assertions.assertEquals(shortestBridge(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,0,1}
        }) , 2);


        Assertions.assertEquals(shortestBridge(new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1},
        }) , 1);
    }



    /*
    * 思路：先通过 dfs 将其中一个岛屿的点 全部入队，然后通过 bfs 一层一层往外扩
    *  多源bfs！！！
    * */



    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    Queue<int[]> queue = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        // 1. 只找第一个岛屿, 将数字全部变成2, 且将边缘的1加入到队列中
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid , i , j);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        System.out.println("dfs 后岛屿为: ");
        for (int[] tmp : grid) System.out.println(Arrays.toString(tmp));
        System.out.println("队列中元素为: ");
        for (int[] tmp : queue) System.out.println(Arrays.toString(tmp));

        // 开始bfs，一层一层往外扩
        int step = 0;
        while (!queue.isEmpty()){
            step++;

            // 把这一层的0全部填为2，再把外层的0再加入队列，逐层填陆地，直到碰到第二片岛屿

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0] , y = cur[1] + dir[1];

                    // 越界了，跳过
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                   // System.out.println("x = " + x + " y = " + y + " grid[x][y]" + grid[x][y]) ;
                    // 将周围的0变成2
                    if (grid[x][y] == 0){
                        grid[x][y] = 2;
                        queue.add(new int[]{x , y});
                    }

                    // 周围出现了另外一座岛屿，直接返回
                    if (grid[x][y] == 1) return step;
                }
            }

             //for (int[] tmp : grid) System.out.println(Arrays.toString(tmp));
        }
        return step;
    }


    // 将相邻的1全部加入到队列中,将原来的1改为2
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2) return;
        if (grid[i][j] == 0){   // 说明是边缘节点
            grid[i][j] = 2;
            queue.add(new int[]{i , j});
            return;
        }
        grid[i][j] = 2;
        queue.add(new int[]{i , j});
        dfs(grid , i+1 , j);
        dfs(grid , i-1 , j);
        dfs(grid , i , j+1);
        dfs(grid , i , j-1);
    }

}
