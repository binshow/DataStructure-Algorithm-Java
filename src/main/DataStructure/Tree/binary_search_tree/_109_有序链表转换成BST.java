package DataStructure.Tree.binary_search_tree;


import DataStructure.List.ListNode;
import DataStructure.Tree.TreeNode;

import java.util.List;

// https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
public class _109_有序链表转换成BST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head , null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
       if (head == tail) return null;
       ListNode fast = head;
       ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

       TreeNode root = new TreeNode(slow.val);
        root.right = buildTree(slow.next , tail);
       slow.next = null;
       root.left = buildTree(head , slow);

       return root;
    }
}
