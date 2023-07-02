package node_list;

import java.util.List;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/1/309:13 PM
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }



      public static ListNode buildList(int[] nums){
          ListNode head = new ListNode(nums[0]);
          ListNode cur = head;
          for (int i = 1; i < nums.length; i++) {
              cur.next = new ListNode(nums[i]);
              cur = cur.next;
          }
          return head;
      }



}


