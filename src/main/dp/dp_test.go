package dp

import (
	"fmt"
	"testing"
)

//========https://leetcode.cn/problems/JEj789=========
func minCost(costs [][]int) int {
	n := len(costs)
	dp := make([][4]int , n+1)
	for i:= 1 ; i <= n ; i++ {
		dp[i][0] = min(dp[i-1][1] , dp[i-1][2]) + costs[i-1][0]
		dp[i][1] = min(dp[i-1][0] , dp[i-1][2]) + costs[i-1][1]
		dp[i][2] = min(dp[i-1][0] , dp[i-1][1]) + costs[i-1][2]
	}
	return min(min(dp[n][0] , dp[n][1]) , dp[n][2])
}

func min(x, y int) int{
	if x < y {
		return x
	}else {
		return y
	}
}

func TestName(t *testing.T) {
	dp := make([][3]int , 3)
	fmt.Println(dp)
	fmt.Println(len(dp))
}
