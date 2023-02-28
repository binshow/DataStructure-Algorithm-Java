package main

import "fmt"

// https://leetcode.cn/problems/maximum-frequency-stack/description/
type FreqStack struct {
	maxFreq int
	mc map[int]int
	ms map[int][]int
}

func Constructor() FreqStack {
	return FreqStack{0, make(map[int]int), make(map[int][]int)}
}

func (fs *FreqStack) Push(val int)  {
	fs.mc[val]++
	fs.ms[fs.mc[val]] = append(fs.ms[fs.mc[val]], val)
	if fs.maxFreq < fs.mc[val] {
		fs.maxFreq = fs.mc[val]
	}
}

func (fs *FreqStack) Pop() int {
	ans := fs.ms[fs.maxFreq][len(fs.ms[fs.maxFreq])-1]
	fs.ms[fs.maxFreq] = fs.ms[fs.maxFreq][:len(fs.ms[fs.maxFreq])-1]
	fs.mc[ans]--
	if len(fs.ms[fs.maxFreq]) == 0 {
		fs.maxFreq--
	}
	return ans
}



func main() {
	var c []int
	c = append(c , 1,2)
	a := c[:len(c)-1]
	fmt.Println(len(a))
	fmt.Println(len(c))
}