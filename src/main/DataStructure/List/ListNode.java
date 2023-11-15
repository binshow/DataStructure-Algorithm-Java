package DataStructure.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }


    public static void printList(ListNode head){
        if (head == null) System.out.println("null");

        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null){
            sb.append(cur.val).append("->");
            cur = cur.next;
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
