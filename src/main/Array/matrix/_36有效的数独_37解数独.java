package Array.matrix;


// https://leetcode.cn/problems/valid-sudoku/
public class _36有效的数独_37解数独 {


    //i是行标，j是列标。行标决定一组block的起始位置（因为block为3行，所以除3取整得到组号，又因为每组block为3个，所以需要乘3），列标再细分出是哪个block（因为block是3列，所以除3取整）

    public boolean isValidSudoku(char[][] board) {

        // 分别记录每行、每列、每块是否存在某个元素
        boolean[][] raw = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int blockIndex = i / 3 * 3 + j / 3; // 矩阵中的格子属于哪个块

                if (raw[i][num] || col[j][num] || block[blockIndex][num]) return false;

                raw[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
            }
        }
        return true;
    }


    public void solveSudoku(char[][] board) {

    }

}
