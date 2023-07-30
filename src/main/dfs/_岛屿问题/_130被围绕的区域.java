package dfs._岛屿问题;

// https://leetcode.cn/problems/surrounded-regions/

public class _130被围绕的区域 {

    //给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i < m ; i++){
            if (board[i][0] == 'O')  dfs(board , i , 0);
            if (board[i][n-1] == 'O') dfs(board , i , n-1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board , 0 , i);
            if (board[m-1][i] == 'O') dfs(board , m-1 , i);
        }

        // 'O' --> 'X'
        // '-' --> 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    // 将 'O' --> '-'
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '-' || board[i][j] == 'X') return;
        board[i][j] = '-';
        dfs(board , i+1 , j);
        dfs(board , i-1 , j);
        dfs(board , i , j+1);
        dfs(board , i , j-1);
    }
}
