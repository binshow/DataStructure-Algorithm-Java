package DataStructure.Array;

public class _45_55_跳跃游戏 {


    //https://leetcode.cn/problems/jump-game/
    //输入：nums = [2,3,1,1,4]
    //输出：true
    //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

    // 问题的本质就是 遇到了 0 能不能跳过去
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;
        for(int i = n-2 ; i >= 0 ; i--){
            if (nums[i] == 0 && !canPass(nums , i)) return false;
        }
        return true;

    }

    private boolean canPass(int[] nums, int index) {
        for (int i = index-1; i >= 0 ; i--) {
            if (nums[i] + i > index) return true;
        }
        return false;
    }



    // https://leetcode.cn/problems/jump-game-ii/
    // 最小跳跃次数
    //输入: nums = [2,3,1,1,4]
    //输出: 2
    //解释: 跳到最后一个位置的最小跳跃数是 2。
    public int jump(int[] nums) {
       int res = 0;
       int curDistance = 0;  // 当前覆盖的最远距离下标
       int nextDistance = 0;  // 下一步覆盖的最远距离下标
        for (int i = 0; i < nums.length - 1; i++) {
            nextDistance = Math.max(nextDistance , nums[i] + curDistance); // 更新下一步覆盖的最远距离下标
            if (i == curDistance){          //  // 遇到当前覆盖的最远距离下标
                curDistance = nextDistance; // 更新当前覆盖的最远距离下标
                res++;
            }
        }
        return res;
    }

}
