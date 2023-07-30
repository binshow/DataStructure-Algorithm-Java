package DataStructure.Array._矩阵问题;

public class _289生命游戏 {

    //https://leetcode.cn/problems/game-of-life/

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board , i , j , res);
            }
        }

        for(int i = 0 ; i < m ; i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }

    }

    private void dfs(int[][] board, int i, int j, int[][] res) {
        // 获取周围的活细胞
        int life = 0;

        if (i < board.length-1 && board[i+1][j] == 1) life++; // 下
        if (i > 0 && board[i-1][j] == 1) life++; // 上
        if (j > 0 && board[i][j-1] == 1) life++;
        if (j < board[0].length - 1 && board[i][j+1] == 1) life++;

        if (i > 0 && j > 0 && board[i-1][j-1] == 1) life++;
        if (i > 0 && j < board[0].length-1 && board[i-1][j+1] == 1) life++;
        if (i < board.length-1 && j > 0 && board[i+1][j-1] == 1) life++;
        if (i < board.length-1 && j < board[0].length-1 && board[i+1][j+1] == 1) life++;

        if (life < 2) res[i][j] = 0;
        else if (life == 2) res[i][j] = board[i][j];
        else if (life == 3) res[i][j] = 1;
        else res[i][j] = 0;

    }




}
