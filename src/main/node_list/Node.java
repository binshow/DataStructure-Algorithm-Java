package node_list;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/6/182:35 PM
 */
public class Node {

    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
