package main

import "math"

func main() {

}

//https://leetcode.cn/problems/largest-sum-of-averages/description/
func largestSumOfAverages(nums []int, K int) float64 {
	n := len(nums)
	//1. 前缀和数组
	sum := make([]float64 , n+1)
	for i := 1; i <= n; i++ {
		sum[i] = sum[i-1] + float64(nums[i-1])
	}

	//2. 定义dp:  n+1 行， K+1 列
	// dp[i][k] 表示前面 i个 元素，分成k组的  平均值之和
	dp:=make([][]float64,n+1)
	for i:=range dp{
		dp[i]=make([]float64,K+1)
	}

	//3. base case: k = 1
	for i := 1; i <= n; i++ {
		dp[i][1] = sum[i] / float64(i)
	}

	//4. 开始 dp
	for i := 1; i <= n; i++ {
		for k := 2; k <= K ; k++ {
			for j := 0; j < i; j++ {
				avg := (sum[i] - sum[j]) / float64(i - j)
				dp[i][k] = math.Max(dp[i][k] , dp[j][k-1] + avg)
			}
		}
	}

	return dp[n][K]
}