package binary_tree

//
//import (
//	"math"
//)
//
//type TreeNode struct {
//	Val int
//	Left  *TreeNode
//	Right *TreeNode
//}
//
//func preorderTraversal(root *TreeNode) []int {
//	res := []int{}
//	if root == nil {
//		return res
//	}
//	stack := []*TreeNode{}
//	DataStructure.stack = append(DataStructure.stack , root)
//	for len(DataStructure.stack) > 0 {
//		cur := DataStructure.stack[len(DataStructure.stack)-1]
//		DataStructure.stack = DataStructure.stack[:len(DataStructure.stack)-1]
//		res = append(res , cur.Val)
//		if cur.Right != nil {
//			DataStructure.stack = append(DataStructure.stack , cur.Right)
//		}
//		if cur.Left != nil {
//			DataStructure.stack = append(DataStructure.stack , cur.Left)
//		}
//	}
//
//	return res
//
//
//
//}
//
//// https://leetcode.cn/problems/find-bottom-left-DataStructure.Tree-value/
//// 查找树的最深最左子节点
//func findBottomLeftValue(root *TreeNode) int {
//	if root == nil {
//		return -1
//	}
//	var node *TreeNode = root
//	queue := []*TreeNode{root}	// 队列
//	for len(queue) > 0 {
//		node = queue[0]
//		queue := queue[1:]
//		if node.Right != nil {
//			queue = append(queue , node.Right)
//		}
//		if node.Left != nil {
//			queue = append(queue , node.Left)
//		}
//	}
//	return node.Val
//}
//
//
////https://leetcode.cn/problems/find-largest-value-in-each-DataStructure.Tree-row/
//func largestValues(root *TreeNode) []int {
//	res := make([]int , 0)
//	if root == nil {
//		return res
//	}
//	queue := []*TreeNode{root}
//	cur := root
//	for len(queue) > 0 {
//		size := len(queue)
//		max := math.MinInt
//		for size > 0 {
//			cur = queue[0]
//			queue = queue[1:]
//			size--
//			if cur.Val > max {
//				max = cur.Val
//			}
//			if cur.Left != nil{
//				queue = append(queue , cur.Left)
//			}
//			if cur.Right != nil {
//				queue = append(queue , cur.Right)
//			}
//		}
//		res = append(res , max)
//	}
//	return res
//
//}
