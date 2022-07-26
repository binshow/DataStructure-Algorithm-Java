package design;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/7/261:47 PM
 */

// 设计一个跳表:https://leetcode.cn/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/
    /*
    Redis底层数据结构:跳表->以O(logN)的时间复杂度内完成增删改查指定元素
    核心原理:建立多层随机索引,将时间复杂度降至logN,具体可参考简书的博客
    重要函数:1.findClosest(node,level,num) (从curNode开始)寻找level内最靠近target的左边节点
            该位置就是在该层内最接近target且<target的位置,将来用于完成插入、删除、查找等操作
            2.randomLevel() 以0.25为概率因子生成最大值为32的随机数
            数字每增加1,出现的概率为前一个数的0.25倍
            如:1出现的概率为0.75;1以上出现的概率为0.25;
            2出现的概率就是0.25*0.75;3出现的概率就是0.25*0.75*0.75
            .......这样可以间接保证每一层的元素成类似于二叉树的结构,最大高度不过logN
    */


public class Skiplist {

    // 最大层数
    private static final int DEFAULT_MAX_LEVEL = 32;

    // 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
    private static final double DEFAULT_P_FACTOR = 0.5;

    Node head;     // 头节点
    int curLevel; // 记录当前的最大层级

    public Skiplist(){
        curLevel = 0;
        head = new Node(-1 , DEFAULT_MAX_LEVEL);
    }

    // 从上往下找到每层的前置节点，再遍历每一层插入新节点
    public void add(int num){
        // updates 数组存储每层应该插入的节点是啥
        Node[] updates = new Node[DEFAULT_MAX_LEVEL];
        Arrays.fill(updates, head);
        Node cur = head;
        // 从当前层级往下找到所有层的前驱节点
        for (int i = curLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];
            updates[i] = cur;
        }

        // 随机生成 level
        int level = randomLevel();
        if (level > curLevel){
           curLevel = level;
        }
        Node newNode = new Node(num , level);

        // 插入随机出来的所有level
        for (int i = 0; i < level; i++) {
            newNode.next[i] = updates[i].next[i];
            updates[i].next[i] = newNode;
        }

    }


    // 从上往下找
    public boolean search(int num){
        Node cur = this.head;
        for (int i = curLevel - 1; i >= 0 ; i--) {
            //找到第i层最大的小于target的元素
            while (cur.next[i] != null && cur.next[i].value < num) {
                cur = cur.next[i];
            }
        }
        cur = cur.next[0]; // 已经是第一层元素了
        return cur.value == num;
    }


    // 从上往下找判断是否存在，如果存在，再从下往上找，找到第一个不等于的节点break
    public boolean erase(int num){
        // 先查找判断是否存在
        Node[] updates = new Node[DEFAULT_MAX_LEVEL];
        Node cur = this.head;
        for (int i = curLevel-1 ; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];
            updates[i] = cur;
        }
        cur = cur.next[0];
        if (cur == null || cur.value != num) return false;

        // 存在节点, 从下往上找
        for (int i = 0; i < curLevel; i++) {
            if (updates[i].next[i] != cur) break;
            //删除第i层的值和num相等的元素
            updates[i].next[i] = cur.next[i];
        }

        //有可能最上层只有一个元素，缩短层数
        while ( curLevel > 1 && head.next[curLevel - 1] == null) curLevel--;
        return true;
    }

    //遍历跳表
    public void printList(){
        for (int i = curLevel - 1; i >= 0 ; i--) {
            Node curNode = this.head.next[i];
            System.out.print("Head->");
            while (curNode != null){
                String line = String.format("(%d)->" , curNode.value);
                System.out.print(line);
                curNode = curNode.next[i];
            }
            System.out.println("Nil");
        }
    }



    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private static int randomLevel(){
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) level++;
        return level;
    }

    // head 1
    // head 1  2        5
    // head 1  2  3  4  5
    static class Node {
        Integer value;  // 节点存储的值
        Node[]  next;   // 上面跳表中的2个5就是存放的 next 数组中 ， next[0] 是下面的这个值

        public Node (Integer value , int level){
            this.value = value;
            this.next = new Node[level];
        }
    }

    public static void main(String[] args) {
        Skiplist list = new Skiplist();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
    }
}
