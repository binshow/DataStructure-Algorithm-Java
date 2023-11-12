package DataStructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class _215_Kth_largest_element_in_array {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a , b) -> a - b);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        System.out.println(heap);
        return heap.peek();
    }
}
