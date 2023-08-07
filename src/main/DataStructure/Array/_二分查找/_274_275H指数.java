package DataStructure.Array._二分查找;

public class _274_275H指数 {


    // https://leetcode.cn/problems/h-index/
    // https://leetcode.cn/problems/h-index-ii/
    public int hIndex(int[] nums) {
        int l = 0 , r = nums.length;
        while(l < r){
            int mid = l + r + 1 >> 1 ;
            if(check(mid , nums)) l = mid;
            else r = mid - 1;
        }
        return l;
    }


    boolean check(int s , int[] nums){
        int count = 0;
        for(int num : nums){
            if(num >= s) count++;
        }
        return count >= s;

    }
}
