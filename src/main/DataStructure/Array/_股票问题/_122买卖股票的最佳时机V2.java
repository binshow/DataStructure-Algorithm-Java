package DataStructure.Array._股票问题;

public class _122买卖股票的最佳时机V2 {

   // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit(int[] prices) {
        // 可以无限买
        int res = 0;
        for(int i = 1 ; i < prices.length ; i++) res += Math.max(0 , prices[i] - prices[i-1]);
        return res;

    }
}
