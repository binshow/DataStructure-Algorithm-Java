package string

func minOperations(s string) int {
	n := len(s)
	res := 0
	c := s[0]
	for i := 1; i < n; i++ {
		if c == '1' && s[i] == '1' {
			res++
			c = '0'
		}else if c == '0' && s[i] == '0' {
			res++
			c = '1'
		}else {
			c = s[i]
		}
	}
	if n-res < res {
		res = n - res
	}
	return res

}

//https://leetcode.cn/problems/number-of-different-integers-in-a-string/description/
func numDifferentIntegers(word string) int {
	n := len(word)
	m := make(map[string]bool)
	for i := 0 ; i < n ; i++ {
		if word[i] >= '0' && word[i] <= '9' {
			j := i
			for j < n && word[j] >= '0' && word[j] <= '9' {
				j++
			}
			tem := word[i : j]
			if tem[0] == '0' {
				index := 1
				for index < len(tem) && tem[index] == '0' {
					index++
				}
				tem = tem[index:]
			}
			m[tem] = true
			i = j
		}
	}

	return len(m)
}