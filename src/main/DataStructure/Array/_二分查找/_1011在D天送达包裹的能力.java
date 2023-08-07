package DataStructure.Array._二分查找;

// https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
public class _1011在D天送达包裹的能力 {

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = weights[0];
        for(int num : weights) {
            max = Math.max(max , num);
            sum += num;
        }
        int l = max , r = sum;
        while(l < r){
            int mid = l + r >> 1;
            if(check(weights , days , mid)) r = mid;
            else l = mid + 1;
        }

        return l;
    }


    static boolean check(int[] nums , int days , int capacity){
        int count = 0;
        int cur = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(cur + nums[i] > capacity){
                count++;
                cur = nums[i];
            } else cur += nums[i];
        }

        return count + 1 <= days;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(check(nums, 5, 11));
    }
}
