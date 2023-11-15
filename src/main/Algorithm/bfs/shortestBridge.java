package Algorithm.bfs;

import java.util.*;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/10/251:40 PM
 */
public class shortestBridge {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0} , {0,0,0} , {0,0,1}};
        shortestBridge(grid);
    }

    //https://leetcode.cn/problems/shortest-bridge/description/

    public static int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        util.printGrid(grid);
        // 第一个dfs：把其中一个岛染色，标记成-1岛, 把每个位置放入队列
        boolean flag  = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dfs(grid , i , j , queue);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println("=======");
        util.printGrid(grid);
        for (int[] tem : queue) System.out.println(Arrays.toString(tem));

        // 第二个，Algorithm.bfs，扩大圈数找最小圈数
        int step = 0 , sz = 0;
        int[][] dir = {{0,1} , {0,-1} , {1,0} , {-1,0}};  // 上下左右四个方向
        while (!queue.isEmpty()){
            sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = queue.poll();
                int x = cell[0] , y = cell[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];
                    if(nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                    if(grid[nx][ny] == 0){
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = -1;
                    } else if(grid[nx][ny] == 1) {
                        return step;
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private static void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1) return;
        grid[i][j] = -1;
        q.offer(new int[]{i, j});
        dfs(grid, i-1, j, q);
        dfs(grid, i, j-1, q);
        dfs(grid, i+1, j, q);
        dfs(grid, i, j+1, q);
    }
}
