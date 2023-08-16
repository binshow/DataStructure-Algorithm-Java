package backtracking._排列问题;

public class _526优美的排列 {

    // https://leetcode.cn/problems/beautiful-arrangement/

    // 类似于全排列
    int res = 0;
    public int countArrangement(int n) {
        boolean[] isv = new boolean[n+1];
        dfs(n ,1 , isv);
        return res;
    }

    private void dfs(int n, int start, boolean[] isv) {
        // 是个优美序列
        if (start == n+1) {
            res++;
            return;
        }

        for(int i = 1 ; i <= n ; i++){
            if (isv[i]) continue;
            // 当前是 start 位置，满足优美排列
            if (i % start != 0 && start % i != 0) continue;
            isv[i] = true;
            dfs(n , start+1 , isv);
            isv[i] = false;
        }
    }


}
