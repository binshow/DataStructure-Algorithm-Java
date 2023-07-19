package listnode;


// https://leetcode.cn/problems/split-linked-list-in-parts/

public class _725分隔链表 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if (head == null) return res;
        //1. 计算链表长度
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        System.out.println("length = " + length);

        //2. mod个元素长度为 size+1
        int mod = length % k;
        int size = length / k;
        System.out.println("mod = " + mod + " size = " + size);

        //3. 前面 mod 个 划分 size + 1 个 ，后面 就划分 size 个一组
        cur = head;
        int index = 0;
        for (int i = 0; i < k; i++) {
            res[index++] = cur;
            int num = mod > 0 ? size + 1 : size;
            mod--;

            while (num > 1){
                cur = cur.next;
                num--;
            }

            if(cur == null) return res;

            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        return res;

    }

}
