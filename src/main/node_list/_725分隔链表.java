package node_list;

import static node_list.ListNode.buildList;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/split-linked-list-in-parts/
 * @date 2023/6/268:33 AM
 */
public class _725分隔链表 {

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 2, 3 , 4, 5, 6, 7,8});

        System.out.println(ListUtil.println(head));

        ListNode[] listNodes = splitListToParts(head, 4);

        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null)
            System.out.println( ListUtil.println(listNodes[i]));
        }

    }




    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            length++;
        }



        // 总共有 k 个组，每个组有 n 个元素， 前面 mod 个组 有n+1个元素
        int mod =  length % k;
        int n = length / k;

        System.out.println("length = " + length + " mod = " + mod + " n = " + n);

        cur = head;
        int index = 0;
        while (k > 0){
            res[index++] = cur;
            int num = mod > 0 ? n+1 : n;
            mod--;

            while (num > 1){    // 少进一位
                cur = cur.next;
                num--;
            }

            if (cur == null) break;

            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;

            k--;
        }

        return res;

    }


}
