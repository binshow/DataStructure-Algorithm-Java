package Algorithm.dp.bag_01;

public class _0_1背包理论基础 {


    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        weightBag(weight,value,bagSize);
    }


    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     *       求能装物品的最大价值
     */
    public static void weightBag(int[] weight , int[] value , int bagSize){

        int n = weight.length;

        // Algorithm.dp[i][j] 表示 前i个物品 装满 j 的最大价值
        // Algorithm.dp[i][j] = Math.max(Algorithm.dp[i-1][j] , Algorithm.dp[i-1][j-weight[i]] + value[i])
        int[][] dp = new int[n][bagSize+1];

        // 只装第一个
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagSize; j++) {

                if (weight[i] > j) // 当前物品装不下
                    dp[i][j] = dp[i-1][j];
                else { // 当前物品可以装，也可以不装
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }


        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }


    }
}
