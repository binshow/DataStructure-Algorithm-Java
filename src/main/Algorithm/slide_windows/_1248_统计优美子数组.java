package Algorithm.slide_windows;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/count-number-of-nice-subarrays/description/
public class _1248_统计优美子数组 {

    //给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
    //
    //请返回这个数组中 「优美子数组」 的数目。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,1,2,1,1], k = 3
    //输出：2
    //解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
    //示例 2：
    //
    //输入：nums = [2,4,6], k = 1
    //输出：0
    //解释：数列中不包含任何奇数，所以不存在优美子数组。
    //示例 3：
    //
    //输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
    //输出：16



    /*
    * 思路： 子数组含有k个奇数数字：
    *
    * */


    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int l = 0 , r = 0;
        int oddCount = 0;
        int res = 0;
        while (r < n){
           if (nums[r] % 2 == 1) oddCount++;
            r++;
            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
            while (oddCount == k){
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                int tmp = r;
                while (r < n && nums[r] % 2 == 0) r++;
                int rnum = r - tmp;


                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int lnum = 0;
                while (nums[l] % 2 == 0) {
                    l++;
                    lnum++;
                }

                // 组合起来
                res += (lnum + 1) * (rnum + 1);

                //此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                l++;
                oddCount--;
            }


        }
        return res;
    }



    // 前缀和

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            // 遍历数组，将奇数改为1，偶数改为0，问题就转换成 和为k的子数组个数
            int n = nums.length;
            int[] tem = new int[n];
            for (int i = 0 ; i < n ; i++){
                tem[i] = (nums[i] & 1) == 1 ? 1 : 0;
            }
            return getCount(tem , k);
        }

        private int getCount(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            Map<Integer , Integer> map = new HashMap<>();
            map.put(0,1);
            int res = 0 , sum = 0;
            for (int i = 0 ; i < nums.length ; i++){
                sum += nums[i];
                if (map.containsKey(sum - k)) res += map.get(sum-k);
                map.put(sum , map.getOrDefault(sum , 0) + 1);
            }
            return res;
        }
    }

}
