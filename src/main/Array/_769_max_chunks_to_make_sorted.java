package Array;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/8/1311:27 AM
 */
public class _769_max_chunks_to_make_sorted {

    // https://leetcode.cn/problems/max-chunks-to-make-sorted/
    // 给一个数组，需要满足三个条件： //1）分块，越多越好（2）块间顺序不变，块内顺序可变（3）重新连接后=升序排序
    // ps : 注意这里说的是 和 排序后的原数组保持不变
    //Input: arr = [1,0,2,3,4]
    //Output: 4
    //Explanation:
    //We can split into two chunks, such as [1, 0], [2, 3, 4].
    //However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
    public int maxChunksToSorted(int[] nums) {
        int res = 0;
        int sum = 0 , index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            index += i;
            if (sum == index){
                res++;
                sum = 0;
                index = 0;
            }
        }
        return res;
    }
    /*
    * 思路解析：
    *  下标： 0 1 2 | 3 4 | 5 6 7
       元素： 2 1 0 | 4 3 | 7 6 5
       * 我们可以遍历数组，每当出现下标之和等于元素之和的一个区间，
       * 就贪心的把该区间划分为一个块，然后在继续寻找下一个满足要求的区间。
    * */


    // https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
    // 可包含重复元素:https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/solution/zui-duo-neng-wan-cheng-pai-xu-de-kuai-ii-deng-jie-/
    // 单调栈法: 1 1 2 1 1 3 4 5 1 6
    // 1 1 5 6
    public int maxChunksToSorted2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums){
            if (!stack.isEmpty() && num < stack.peek()){
                int tem = stack.pop();
                while (!stack.isEmpty() && num < stack.peek()) stack.pop();
                stack.push(tem);
            }else stack.push(num);
        }
        return stack.size();
    }






}
