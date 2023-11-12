package DataStructure.heap;


import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.cn/problems/find-median-from-data-stream/description/
public class _295_find_median_from_datastream {






    /*
    *
    * 思路：维护两个堆
    * */

    static class MedianFinder {

        Queue<Integer> min = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        Queue<Integer> max = new PriorityQueue<>((a , b) -> b - a);  // 大顶堆，保存较小的一半
        public MedianFinder() {

        }


        public void addNum(int num) {
            if (min.size() == max.size()){
                max.add(num);
                min.add(max.poll());
            }else {
                min.add(num);
                max.add(min.poll());
            }
        }

        // m = n 时。
        // m != n 时， 中位数为 大顶堆的 根处
        public double findMedian() {
            return min.size() != max.size() ? min.peek() : (min.peek() + max.peek()) / 2.0;
        }
    }

}
