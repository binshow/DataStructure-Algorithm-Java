package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/lfu-cache/
 * @date 2023/6/159:47 AM
 */
public class LFUCache {

    // 节点对象
    static class Node {
        int key;
        int val;
        int freq = 1; // 频率
        Node pre;
        Node next;
        public Node(){}
        public Node(int key , int val ){
            this.key = key;
            this.val = val;
        }
    }

    // 双向链表
    static class LinkedList {
        Node head;
        Node tail;
        public LinkedList(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void insertFirst(Node node){
            if (node == null) return;
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        void removeNode(Node node){
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
    }

    // LFU 的正式实现
    Map<Integer , Node> map = new HashMap<>(); // 保存key 和 node
    Map<Integer , LinkedList> freqMap = new HashMap<>(); // 频率 --> 双向链表
    int size; // 当前元素数量
    int capacity; // 容量
    int minFreq  = 0; // 最小频率

    public LFUCache(int capacity){
        this.capacity = capacity;
    }

    // LFU cache 中获取元素
    public int get(int key){
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        // 给 node 增加频率, 更新最小频率 同时从该节点从一个 频率对应的链表 取下放到 另外一个链表的头部
        freqInc(node);
        return node.val;
    }

    // LFU cache 中加入元素
    public void put(int key , int val){
        if (capacity == 0) return;
        Node node = map.get(key);
        if (node != null){  // 节点已经存在，覆盖值，更新频率
            node.val = val;
            freqInc(node);
        }else {
            // 节点不存在新增节点
            if (size == capacity){  // 容量满了，最小频率的链表删除尾部节点
                LinkedList list = freqMap.get(minFreq);
                Node temp = list.tail.pre; // 删除temp
                map.remove(temp.key);
                list.removeNode(temp);
                size--;
            }
            // 构造新节点  加入到频率为1的链表中
            Node cur = new Node(key , val);
            map.put(key , cur);
            LinkedList list = freqMap.get(1);
            if (list == null) {
                list = new LinkedList();
                freqMap.put(1  , list);
            }
            list.insertFirst(cur);

            // 更新最小频率 和 size
            minFreq = 1;
            size++;
        }
    }


    private void freqInc(Node node) {
        int freq = node.freq;
        // 取出链表，删除该节点
        LinkedList list = freqMap.get(freq);
        list.removeNode(node);
        // 是否更新最小频率
        if (freq == minFreq && list.head.next == list.tail) minFreq = freq+1;
        // 更新节点频率
        node.freq++;
        // 取出新链表,如果没有初始化就进行初始化塞入map 中
        LinkedList list2 = freqMap.get(freq + 1);
        if (list2 == null){
            list2 = new LinkedList();
            freqMap.put(freq+1 , list2);
        }
        list2.insertFirst(node);
    }

}
