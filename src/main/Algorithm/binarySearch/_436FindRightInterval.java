package Algorithm.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/find-right-interval/
public class _436FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;

        int[] res = new int[n];
        Arrays.fill(res , -1);

        // key 为区间起点，value 为 区间起点 在数组中的位置
        Map<Integer , Integer> map = new HashMap<>();
        int index = 0;
        for(int[] tmp : intervals){
            map.put(tmp[0] , index++);
        }

        //System.out.println(map);

        // 12 || 23 || 34
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = intervals[i][0];

        // nums 为递增数组
        System.out.println(Arrays.toString(nums));

        // 遍历每个 区间的右节点 ，在 nums 中二分查找
        for(int i = 0 ; i < n ; i++){
            int cur = find(nums , intervals[i][1]);
            //System.out.println("比 " + intervals[i][1] + " 更大的数为 " + cur);
            if(cur != Integer.MIN_VALUE) {
                //System.out.println(intervals[i][0] + "的右区间为 " +  cur);
                res[map.get(intervals[i][0])] = map.get(cur);
            }
        }

        return res;

    }

    // 返回比 target 大的第一个元素，没有的话则返回 Integer.MIN_VALUE
    int find(int[] nums , int target){
        int n = nums.length;
        if(nums[n-1] < target) return Integer.MIN_VALUE;
        int l = 0 , r = n-1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
