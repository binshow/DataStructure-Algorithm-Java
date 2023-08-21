package Algorithm.backtracking._八皇后问题;

import java.util.ArrayList;
import java.util.List;

public class _51_52N皇后 {

    // https://leetcode.cn/problems/n-queens/

    // 多少种解决方案



    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // 初始化棋盘
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) board[i][j] = '.';
        // 从第0行开始
         dfs(n , 0 , board , res);
         return res;

    }

    void dfs(int n , int row, char[][] board , List<List<String>> res){
        //1. 递归截止条件
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(char[] chars : board) list.add(new String(chars));
            res.add(list);
            return;

        }
        //2. 行确定，开始遍历每一列
        for(int i = 0 ; i < n ; i++){
            // 3. 判断 row 行， i 列存放 Q 是否有效
            if(!isValid(board, row, i, n)) continue;
            board[row][i] = 'Q';
            dfs(n , row + 1, board , res);
            board[row][i] = '.'; // 回溯
        }
    }

    // 判断 当前行 、当前列 存放 Q 是否可行
    private boolean isValid(char[][] matrix, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (matrix[i][col] == 'Q') return false;
        }

        //45 度对角线
        for(int i = row-1 , j = col-1 ; i >= 0 && j >= 0; i-- , j--){
            if (matrix[i][j] == 'Q') return false;
        }

        //135度对角线
        for(int i = row-1 , j = col + 1 ; i >= 0 && j < n ; i-- , j++){
            if (matrix[i][j] == 'Q') return false;
        }

        return true;
    }




}
