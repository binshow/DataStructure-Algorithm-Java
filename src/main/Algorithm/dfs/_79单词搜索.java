package Algorithm.dfs;

// https://leetcode.cn/problems/word-search/
public class _79单词搜索 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isv = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i , j , 0 , word , board , isv)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] isv) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return false;
        if (board[i][j] != word.charAt(index) || isv[i][j]) return false;

        isv[i][j] = true;

        if (    dfs(i+1 , j , index+1 , word , board , isv)
                || dfs(i-1 , j , index+1 , word , board , isv)
                || dfs(i , j+1 , index+1 , word , board , isv)
                || dfs(i , j-1 , index+1 , word , board , isv) ) return true;

        isv[i][j] = false;
        return false;
    }
}
