package DataStructure.Array._矩阵问题;


// https://leetcode.cn/problems/valid-sudoku/
public class _36有效的数独_37解数独 {


    //i是行标，j是列标。行标决定一组block的起始位置（因为block为3行，所以除3取整得到组号，又因为每组block为3个，所以需要乘3），列标再细分出是哪个block（因为block是3列，所以除3取整）

    //输入：board =
    //[["5","3",".",".","7",".",".",".","."]
    //,["6",".",".","1","9","5",".",".","."]
    //,[".","9","8",".",".",".",".","6","."]
    //,["8",".",".",".","6",".",".",".","3"]
    //,["4",".",".","8",".","3",".",".","1"]
    //,["7",".",".",".","2",".",".",".","6"]
    //,[".","6",".",".",".",".","2","8","."]
    //,[".",".",".","4","1","9",".",".","5"]
    //,[".",".",".",".","8",".",".","7","9"]]
    //输出：true


    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ;i < board.length ; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!isValid(board , i , j , board[i][j])) return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y , int val) {

        int raw = board.length;
        int col = board[0].length;

        //数字 1-9 在每一行只能出现一次。
        for (int i = 0; i < col; i++) {
            if (board[x][i] == val && i != y) return false;
        }
        for (int i = 0; i < raw; i++) {
            if (board[i][y] == val && i != x) return false;
        }
        // 九宫格
        int startRaw = (x / 3) * 3;
        int startCol = (y / 3) * 3;
        for (int i = startRaw; i < startRaw + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val && i != x && j != y) return false;
            }
        }
        return true;

    }


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
