package node_list;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/4ueAj6/
 * @date 2022/6/182:34 PM
 */

public class insert_cycle_list {

    // 给定的节点可能是 循环链表中随机的一个节点
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        //1. 先找真正的头节点
        Node realHead = null;
        Node cur = head;
        Node tem = head.next;
        while (cur.val <= tem.val){
            cur = cur.next;
            tem = tem.next;
            if (cur == head) break;
        }
        realHead = tem;

        System.out.println("realHead = " + realHead.val);

        //2. 开始寻找插入的位置
        //  cur  tem ....
        while (tem.val < insertVal){
            cur = tem;
            tem = tem.next;
            if (tem == realHead) break; // 找了一圈，发现还是没有插入的位置，就插入 cur - tem 之间了
        }

        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = tem;
        return  head;
    }
}
