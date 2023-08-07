package DataStructure.Array._双指针._快慢指针;

import DataStructure.List.ListNode;

import java.util.Arrays;


public class _80删除排序数组中的重复项 {


    //https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/

    //输入：nums = [1,1,1,2,2,3]
    //输出：5, nums = [1,1,2,2,3]
    //解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。


    // https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solution/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int index = 1;

        for (int i = 2; i < n; i++) {
            if (nums[i-1] != nums[i]){
                index++;
                nums[index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index + 1;
    }




    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }

}
