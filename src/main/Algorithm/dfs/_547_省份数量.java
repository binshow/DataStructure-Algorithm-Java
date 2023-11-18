package Algorithm.dfs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.cn/problems/number-of-provinces/description/
public class _547_省份数量 {



    //有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
    //
    //省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
    //
    //给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
    //
    //返回矩阵中 省份 的数量。


    //示例 1：
    //
    //
    //输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    //输出：2
    //示例 2：
    //
    //
    //输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
    //输出：3


    @Test
    void test(){
        Assertions.assertEquals(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}) , 2);
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1){
                    dfs(isConnected , i , j);
                    res++;
                }
            }
        }
        return res;
    }


    // 将 x城市  和 y城市 相连的城市都置为 0
    private void dfs(int[][] isConnected, int x, int y) {
        int n = isConnected.length;
        isConnected[x][y] = 0;
        isConnected[y][x] = 0;

        for (int i = 0; i < n; i++) {
            // 遍历第x行 和 第y行
            if (isConnected[x][i] == 1) dfs(isConnected , x , i);
            if (isConnected[y][i] == 1) dfs(isConnected , y , i);

            // 遍历第x列 和 第y列
            if (isConnected[i][x] == 1) dfs(isConnected , i , x);
            if (isConnected[i][y] == 1) dfs(isConnected , i , y);
        }
    }


}
