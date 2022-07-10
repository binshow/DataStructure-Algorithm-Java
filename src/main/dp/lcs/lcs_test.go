package lcs_test

import (
	"fmt"
	"testing"
)

func TestString(t *testing.T) {
	s := "abcdef"
	fmt.Println(s[1])
}

func longestCommonSubsequence(s string, p string) int {
	ls := len(s)
	lp := len(p)
	dp := make([][]int , ls+1)
	for i, _ := range dp {
		dp[i] = make([]int , lp+1)
	}
	dp[0][0] = 0
	for i := 1 ; i<= ls ; i++ {
		for j := 1 ;j <= lp ; j++ {
			if s[i-1] == p[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			}else {
				dp[i][j] = maxInt(dp[i-1][j] , dp[i][j-1])
			}
		}
	}
	return dp[ls][lp]
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}else {
		return b
	}
}
