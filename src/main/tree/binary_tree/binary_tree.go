package binary_tree

type TreeNode struct {
	Val int
	Left  *TreeNode
	Right *TreeNode
}


// https://leetcode.cn/problems/find-bottom-left-tree-value/
// 查找树的最深最左子节点
func findBottomLeftValue(root *TreeNode) int {
	if root == nil {
		return -1
	}
	var node *TreeNode = root
	queue := []*TreeNode{root}	// 队列
	for len(queue) > 0 {
		node = queue[0]
		queue := queue[1:]
		if node.Right != nil {
			queue = append(queue , node.Right)
		}
		if node.Left != nil {
			queue = append(queue , node.Left)
		}
	}
	return node.Val
}