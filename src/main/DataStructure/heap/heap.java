package DataStructure.heap;


// 学习文档：https://www.hello-algo.com/chapter_heap/heap/#811

import java.util.*;

public class heap {


    public static void main(String[] args) {
        /* 初始化堆 */
// 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
// 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /* 元素入堆 */
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);

        /* 获取堆顶元素 */
        int peek = maxHeap.peek(); // 5

        /* 堆顶元素出堆 */
// 出堆元素会形成一个从大到小的序列
        peek = maxHeap.poll(); // 5
        peek = maxHeap.poll(); // 4
        peek = maxHeap.poll(); // 3
        peek = maxHeap.poll(); // 2
        peek = maxHeap.poll(); // 1

        /* 获取堆大小 */
        int size = maxHeap.size();

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();

        /* 输入列表并建堆 */
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
    }



    // 使用list来模拟堆的实现
    List<Integer> maxHeap = new ArrayList<>();


    // =============== 索引映射
    int left(int i){
        return i * 2 + 1;
    }

    int right(int i){
        return i * 2 + 2;
    }

    int parent(int i){
        return (i - 1) / 2;
    }

    int peek(){
        return maxHeap.get(0);
    }


    // 添加元素
    void push(int val){
        maxHeap.add(val);

        // 从底至顶 堆化
        siftUp(maxHeap.size()-1);
    }

    private void siftUp(int i) {
        while (true){
            int p = parent(i);
            // 当“越过根节点”或“节点无须修复”时，结束堆化
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p))
                break;
            // 交换两节点
            swap(i, p);
            // 循环向上堆化
            i = p;

        }
    }



    /* 元素出堆 */
    int pop() {
        // 判空处理
        if (maxHeap.isEmpty())
            throw new IndexOutOfBoundsException();
        // 交换根节点与最右叶节点（即交换首元素与尾元素）
        swap(0, maxHeap.size() - 1);
        // 删除节点
        int val = maxHeap.remove(maxHeap.size() - 1);
        // 从顶至底堆化
        siftDown(0);
        // 返回堆顶元素
        return val;
    }

    /* 从节点 i 开始，从顶至底堆化 */
    void siftDown(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < maxHeap.size() && maxHeap.get(l) > maxHeap.get(ma))
                ma = l;
            if (r < maxHeap.size() && maxHeap.get(r) > maxHeap.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }



    private void swap(int i, int j) {
        int tmp = maxHeap.get(i);
        maxHeap.set(i , maxHeap.get(j));
        maxHeap.set(j , tmp);
    }

}
