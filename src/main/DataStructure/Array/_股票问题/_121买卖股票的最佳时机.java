package DataStructure.Array._股票问题;

public class _121买卖股票的最佳时机 {

    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/submissions/
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int res = 0;
        for(int num : prices){
            res = Math.max(res , num - min);
            min = Math.min(min , num);
        }
        return res;

    }
}
