package Algorithm.dp

import (
	"fmt"
	"testing"
)

//========https://leetcode.cn/problems/JEj789=========
func minCost(costs [][]int) int {
	n := len(costs)
	Algorithm.dp := make([][4]int , n+1)
	for i:= 1 ; i <= n ; i++ {
		Algorithm.dp[i][0] = min(Algorithm.dp[i-1][1] , Algorithm.dp[i-1][2]) + costs[i-1][0]
		Algorithm.dp[i][1] = min(Algorithm.dp[i-1][0] , Algorithm.dp[i-1][2]) + costs[i-1][1]
		Algorithm.dp[i][2] = min(Algorithm.dp[i-1][0] , Algorithm.dp[i-1][1]) + costs[i-1][2]
	}
	return min(min(Algorithm.dp[n][0] , Algorithm.dp[n][1]) , Algorithm.dp[n][2])
}

func min(x, y int) int{
	if x < y {
		return x
	}else {
		return y
	}
}

func TestName(t *testing.T) {
	Algorithm.dp := make([][3]int , 3)
	fmt.Println(Algorithm.dp)
	fmt.Println(len(Algorithm.dp))
}
