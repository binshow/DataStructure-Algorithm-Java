package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/split-array-largest-sum/description/
public class _410SplitArrayLargestSum {

    @Test
    void test(){
//        Assertions.assertEquals(splitArray(new int[]{7,2,5,10,8} , 2) , 18);
//        Assertions.assertEquals(splitArray(new int[]{1,2,3,4,5} , 2) , 9);
//        Assertions.assertEquals(splitArray(new int[]{1,4,4} , 3) , 4);

        Map<int[] , Integer> map = new HashMap<>();
        map.put(new int[]{1,2} , 2);
        System.out.println(map.get(new int[]{1, 2}));
    }

    // 分割数组的最大值
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        System.out.println(sum); // 32
        int l = 0 , r = sum;
        while (l < r){
            int mid = l + r >> 1;
            System.out.println("mid:" + mid);
            if (check(nums , mid , k)) {
                System.out.println("mid can split : " + mid);
                r = mid;
            }
            else l = mid+1;
        }
        return l;
    }


    // 是否能将数组 分为 k 个 子数组，每个子数组的 和 最大为max
    private boolean check(int[] nums, int max, int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if(sum > max){
                sum = nums[i];
                count++;
            }
        }
        System.out.println("mid : " + max  + "count: " + count);
        return count <= k;
    }


}
