package monotone_stack

import (
	"fmt"
	"testing"
)

//42. 接雨水

// 解法1：预处理最大值数组
func trap(height []int) int {
	n := len(height)
	if n < 2 {
		return 0
	}
	maxL := make([]int , n)
	maxR := make([]int , n)
	for i := 1; i < n; i++ {
		_ , maxL[i] = diffMaxMin(maxL[i-1] , height[i-1])
	}
	fmt.Println(maxL)
	for i := n-2; i > 0 ; i-- {
		_ , maxR[i] = diffMaxMin(maxR[i+1] , height[i+1])
	}
	fmt.Println(maxR)
	res := 0
	for i := 0; i < n; i++ {
		min  , _ := diffMaxMin(maxL[i] , maxR[i])
		if min > height[i] {
			res += min - height[i]
		}
	}
	return res
}

func diffMaxMin(a, b int) (min , max int) {
	if a < b {
		return a , b
	}else {
		return b , a
	}
}

// 解法2：单调栈
func trap2(height []int) int {
	n := len(height)
	if n < 2 {
		return 0
	}
	stack := []int{}
	res := 0
	for i := 0; i < n; i++ {
		// i 是 右墙
		// 第一次弹出的是 底部bottom
		// 第二次弹出的是 左墙
		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
			bottom := stack[len(stack)-1]
			stack = stack[0:len(stack)-1]
			if len(stack) <= 0 {
				break
			}
			l := stack[len(stack)-1] // 左墙
			res += (i - l - 1) * (minInt(height[l] , height[i]) - height[bottom])
		}
		stack = append(stack,i)
	}
	return res
}

func minInt(a, b int) int {
	if a > b {
		return b
	}else {
		return a
	}
}

func TestTrap(t *testing.T) {
	nums := []int{0,1,0,2,1,0,1,3,2,1,2,1}
	println(trap(nums))
}
