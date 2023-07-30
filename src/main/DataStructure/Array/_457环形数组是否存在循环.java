package DataStructure.Array;

public class _457环形数组是否存在循环 {

    //https://leetcode.cn/problems/circular-array-loop/

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            // 以当前点为起点能否循环
            if (check(nums , i)) return true;
        }
        return false;
    }

    private boolean check(int[] nums, int start) {
        int cur = start;
        boolean flag = nums[start] > 0;
        int n = nums.length;
        int k = 1;
        while (true){
            if (k > nums.length) return false;
            int next = cur;
            if (nums[cur] > 0){
                next = (cur + nums[cur]) % n;
            }else {
                next = (cur + nums[cur]) % n + n ;
            }

            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            cur = next;
            k++;
        }
    }

}
