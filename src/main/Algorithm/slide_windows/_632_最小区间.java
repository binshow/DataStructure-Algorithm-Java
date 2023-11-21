package Algorithm.slide_windows;


// https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/description/

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _632_最小区间 {


    //你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
    //
    //我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
    //输出：[20,24]
    //解释：
    //列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
    //列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
    //列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
    //示例 2：
    //
    //输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
    //输出：[1,1]



    /*
    *  思路：三个数组都是 非递减的，可以参考 合并k个有序链表的方式，使用一个堆，每次从3个数组中弹出 最小的元素
    *
    *
    * */

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];

        // 第一个数为元素，第二个数 为 第几个list
        Queue<int[]> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            heap.add(new int[]{nums.get(i).get(0) , i});
        }

        while (heap.size() > 3){
            int[] a = heap.poll();
            int[] b = heap.poll();
            int[] c = heap.poll();

            // 拿出 a ，b ，c 里面最小的元素
            int min = Math.min(a[0] , Math.min(b[0] , c[0]));


        }



        return new int[0];
    }

}
