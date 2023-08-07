package DataStructure.Design;

// https://leetcode.cn/problems/design-hashset/
public class MyHashSet {

    static class Node {
        int key;
        Node next;
        public Node(int key){
            this.key = key;
        }
    }

    int capacity = 16;
    Node[] nodes = new Node[capacity];

    public MyHashSet(){}


    public void add(int key){
        int index = getIndex(key);
        Node cur = nodes[index];

        // 如果数组中存在对应位置的节点，遍历链表查看是否已经存在key了
        if (cur != null){
            Node temp = cur;
            while (temp != null){
                if (temp.key == key) return;
                temp = temp.next;
            }
        }

        // 头插法
        Node node = new Node(key);
        node.next = cur;
        nodes[index] = node;
    }



    public void remove(int key) {
        int index = getIndex(key);
        Node cur = nodes[index];
        // 节点为空，说明不存在值
        if (cur == null) return;

        // 节点不为空，且头节点就是 key，直接删除头节点
        if (cur.key == key) {
            nodes[index] = cur.next;
            cur = null;
            return;
        }


       // 遍历链表，找到 key，删除该节点
        Node temp = cur.next;
        while (temp != null){
            if (temp.key == key){
                cur.next = temp.next;
                temp = null;
                return;
            }
            cur = cur.next;
            temp = temp.next;
        }

    }

    public boolean contains(int key) {
        int index = getIndex(key);
        Node cur = nodes[index];
        // 节点为空，说明不存在值
        if (cur == null) return false;

        while (cur != null){
            if (cur.key == key) return true;
            cur = cur.next;
        }
        return false;
    }


    private int getIndex(int key) {
        return key & (nodes.length-1);
    }

}
