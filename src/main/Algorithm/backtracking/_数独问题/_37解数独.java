package Algorithm.backtracking._数独问题;

public class _37解数独 {

    // https://leetcode.cn/problems/sudoku-solver/

    // 思路：遍历每一行每一列，每个元素从 1 - 9 之间试
    public void solveSudoku(char[][] board) {
        dfs(board , 0 , 0 );
    }

    //mark：dfs找到答案就结束递归的话，可以考虑bool值返回的函数!!!
    private boolean dfs(char[][] board , int i , int j) {

        if (i == board.length) return true;
        // 到达该行的末尾，则换到下一行重新开始
        if (j == board[0].length) return dfs(board , i+1 , 0);
        if (board[i][j] != '.') return dfs(board , i , j + 1);

        for (char k = '1'; k <= '9'; k++) {
            if (isValid(i , j , k , board)){
                board[i][j] = k;
                if (dfs(board , i , j+1)) return true;
                board[i][j] = '.';
            }
        }


       return false;
    }

    private boolean isValid(int raw, int col, char k, char[][] board) {
        // 同一行
        for(int i = 0 ; i < board[0].length ; i++){
            if (board[raw][i] == k) return false;
        }

        // 同一列
        for(int i = 0 ; i < board.length ; i++){
            if (board[i][col] == k) return false;
        }

        // 9空格
        int startRaw = (raw / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRaw ; i <  startRaw + 3 ; i++){
            for(int j = startCol ; j < startCol + 3 ; j++){
                if (board[i][j] == k) return false;
            }
        }
        return true;
    }


}
