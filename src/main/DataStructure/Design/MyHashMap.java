package DataStructure.Design;

// https://leetcode.cn/problems/design-hashmap/description/

public class MyHashMap {

    static class Node {
        int key;
        int val;
        Node next;
        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity = 16;
    Node[] buckets = new Node[capacity];

    public MyHashMap() {}

    public void put(int key, int value) {
        int index = getIndex(key);
        Node cur = buckets[index];

        // 索引位置不为空，遍历链表，更新value
        if (cur != null){
            Node tmp = cur;
            while (tmp != null){
                if (tmp.key == key){
                    tmp.val = value;
                    return;
                }
                tmp = tmp.next;
            }
        }

        // 头插法，构造新节点
        Node node = new Node(key , value);
        node.next = cur;

        buckets[index] = node;
    }

    public int get(int key) {
        int index = getIndex(key);
        Node cur = buckets[index];
        if (cur != null){
            Node tmp = cur;
            while (tmp != null){
                if (tmp.key == key) return tmp.val;
                tmp = tmp.next;
            }
        }
        // 没有值
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node cur = buckets[index];
        if (cur == null) return;
        if (cur.key == key) {
            buckets[index] = cur.next;
            cur = null;
            return;
        }

        Node tmp = cur.next;
        while (tmp != null){
            if (tmp.key == key){
                cur.next = tmp.next;
                return;
            }
            tmp = tmp.next;
            cur = cur.next;
        }
    }

    int getIndex(int key){
        return key & (buckets.length-1);
    }

}
