package Algorithm.backtracking._数独问题;

public class _36判断是否是有效的数独 {

    // https://leetcode.cn/problems/valid-sudoku/description/

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == '.') continue;
                if(!isValid(i , j , board[i][j] , board)) return false;
            }
        }
        return true;

    }

    private boolean isValid(int raw, int col, char k, char[][] board) {
        // 同一行
        for(int i = 0 ; i < board[0].length ; i++){
            if (board[raw][i] == k && i != col) return false;
        }

        // 同一列
        for(int i = 0 ; i < board.length ; i++){
            if (board[i][col] == k && i != raw) return false;
        }

        // 9空格
        int startRaw = (raw / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRaw ; i <  startRaw + 3 ; i++){
            for(int j = startCol ; j < startCol + 3 ; j++){
                if (board[i][j] == k && i != raw && j != col) return false;
            }
        }
        return true;
    }
}
