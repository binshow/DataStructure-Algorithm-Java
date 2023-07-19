package listnode;


// https://leetcode.cn/problems/lru-cache/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _146LRU缓存 {


    // map + 双向 list 实现

    class LRUCache {

        Map<Integer , ListNode> map = new HashMap<>();
        int capacity;
        ListNode dummyHead;
        ListNode dummyTail;


        public LRUCache(int capacity) {
            dummyHead = new ListNode();
            dummyTail = new ListNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            ListNode cur = map.get(key);
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
            // cur 移到最前面
            moveToHead(cur);
            return cur.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                // 存在，更新value, 移到链表头部
                ListNode cur = map.get(key);
                moveToHead(cur);
                cur.val = value;
                return;
            }

            // 不存在，加入到第一个节点
            ListNode cur = new ListNode(key , value);
            moveToHead(cur);
            map.put(key , cur);

            // 查看是否要删除最后一个节点
            if (map.size() > capacity){
                ListNode tail = removeTail();
                map.remove(tail.key);
            }

        }

        void moveToHead(ListNode cur){


            ListNode old = dummyHead.next;
            cur.next = old;
            old.pre = cur;

            dummyHead.next = cur;
            cur.pre = dummyHead;
        }


        ListNode removeTail(){
            ListNode res = dummyTail.pre;

            ListNode tail = res.pre;
            tail.next = dummyTail;
            dummyTail.pre = tail;

            return res;
        }



    }

    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;
        public ListNode(){}
        public ListNode(int key , int val){
            this.key = key;
            this.val = val;
        }
    }
}
