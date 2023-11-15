package DataStructure.heap;

import DataStructure.List.ListNode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _23_merge_k_sorted_lists {


    //You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    //
    //Merge all the linked-lists into one sorted linked-list and return it.
    //
    //Example 1:
    //
    //Input: lists = [[1,4,5],[1,3,4],[2,6]]
    //Output: [1,1,2,3,4,4,5,6]
    //Explanation: The linked-lists are:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //merging them into one sorted list:
    //1->1->2->3->4->4->5->6
    //Example 2:
    //
    //Input: lists = []
    //Output: []
    //Example 3:
    //
    //Input: lists = [[]]
    //Output: []
    //Constraints:


    //https://leetcode.cn/problems/merge-k-sorted-lists/description/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        Queue<ListNode> heap = new PriorityQueue<>((a , b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }

        while (!heap.isEmpty()){
            ListNode node = heap.poll();
            cur.next = node;
            cur  = node;
            if (node.next != null) heap.add(node.next);
        }
        return dummy.next;

    }
}
