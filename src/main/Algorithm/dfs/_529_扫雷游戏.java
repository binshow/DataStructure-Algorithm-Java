package Algorithm.dfs;

public class _529_扫雷游戏 {


    //让我们一起来玩扫雷游戏！
    //
    //给你一个大小为 m x n 二维字符矩阵 board ，表示扫雷游戏的盘面，其中：
    //
    //'M' 代表一个 未挖出的 地雷，
    //'E' 代表一个 未挖出的 空方块，
    //'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
    //数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
    //'X' 则表示一个 已挖出的 地雷。
    //给你一个整数数组 click ，其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）中的下一个点击位置（clickr 是行下标，clickc 是列下标）。
    //
    //根据以下规则，返回相应位置被点击后对应的盘面：
    //
    //如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
    //如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
    //如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
    //如果在此次点击中，若无更多方块可被揭露，则返回盘面。



    //   ["E","E","E","E","E"]      --->        ["B","1","E","1","B"]
    //   ["E","E","M","E","E"]                  ["B","1","M","1","B"]
    //   ["E","E","E","E","E"]                  ["B","1","1","1","B"]
    //   ["E","E","E","E","E"]                  ["B","B","B","B","B"]

    // click = [3,0]


    int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; // 周边8个方向
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0] , y = click[1];

        // 遇到地雷了，直接return
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }

        // 将周边的 E 变成 B ， 地雷 M 附近的不能变
        dfs(board , x , y);

        return board;
    }

    private void dfs(char[][] board, int x, int y) {

        // 判断当前点周围的 地雷数量
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int a = x + dirs[i][0] , b = y + dirs[i][1];
            if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && board[a][b] == 'M') count++;
        }

        // 如果存在地雷，就显示数字，不继续挖了
        if (count > 0) {
            board[x][y] = (char)(count + '0');
            return;
        }


        // 不存在地雷，改变当前值，递归的遍历周围的节点
        board[x][y] = 'B';
        for (int i = 0; i < 8; i++) {
            int a = x + dirs[i][0] , b = y + dirs[i][1];
            if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && board[a][b] == 'E') dfs(board , a , b);
        }

    }




    // bfs 解法
    //与树的 BFS 不一样（每个节点只有一个父亲节点），本题图中的点会由多个点达到，因此需要加上 boolean[][] visited 数组记录访问标志，防止每个点重复入队而超时

    /*
    * class Solution {
    // 定义 8 个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        // 2. 若起点是空地，则将起点入队，从起点开始向 8 邻域的空地进行宽度优先搜索。
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            // 判断空地 (i, j) 周围是否有雷
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                    continue;
                }
                if (board[newX][newY] == 'M') {
                    cnt++;
                }
            }
            // 若空地 (i, j) 周围有雷，则将该位置修改为雷数；否则将该位置更新为 ‘B’，并将其 8 邻域中的空地入队，继续进行 bfs 搜索。
            if (cnt > 0) {
                board[i][j] = (char)(cnt + '0');
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length
                        || board[newX][newY] != 'E' || visited[newX][newY]) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return board;
    }
}

作者：Sweetiee 🍬
链接：https://leetcode.cn/problems/minesweeper/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    *
    * */


}
