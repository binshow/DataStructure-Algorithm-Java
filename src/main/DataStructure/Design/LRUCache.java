package DataStructure.Design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/1510:13 AM
 */
public class LRUCache {

    static class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(){}
        public ListNode(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer , ListNode> map = new HashMap<>();
    int cap;
    ListNode dummyHead;
    ListNode dummyTail;

    public LRUCache(int capacity){
        this.cap = capacity;
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key){
        if (!map.containsKey(key)) return -1;
        ListNode res = map.get(key);

        res.next.pre = res.pre;
        res.pre.next = res.next;

        moveToHead(res);
        return res.val;
    }

    public void put(int key , int value){
        if (map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = value;
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            moveToHead(cur);
            return;
        }

        if (map.size() == cap){
            ListNode tail = removeTail();
            map.remove(tail.key);
        }

        ListNode cur = new ListNode(key ,value);
        moveToHead(cur);
        map.put(key , cur);
    }

    private ListNode removeTail() {
        ListNode tail = dummyTail.pre;
        ListNode newTail = tail.pre;
        newTail.next = dummyTail;
        dummyTail.pre = newTail;
        return tail;
    }

    private void moveToHead(ListNode cur) {
        ListNode old = dummyHead.next;
        dummyHead.next = cur;
        cur.pre = dummyHead;

        cur.next = old;
        old.pre = cur;
    }


    public void printLRU(){
        StringBuilder sb = new StringBuilder();
        ListNode head = dummyHead.next;
        while (head != dummyTail){
           sb.append(head.val).append("-");
           head = head.next;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}

        lRUCache.printLRU();

        System.out.println(lRUCache.get(1));


        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

        System.out.println("====");
        lRUCache.printLRU(); // 3

        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }


}
