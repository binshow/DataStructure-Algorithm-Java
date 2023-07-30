package DataStructure.Array._双指针._快慢指针;

import DataStructure.List.ListNode;

import java.util.Arrays;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
public class _26删除排序数组中的重复项 {


    //给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
    // 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。


    //输入：nums = [0,0,1,1,1,2,2,3,3,4]
    //输出：5, nums = [0,1,2,3,4]
    //解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int index = 1;
        int tem = nums[0];

        for(int i = 1 ; i < n ; i++){
            if (nums[i] == tem) continue;
            else {
                nums[index++] = nums[i];
                tem = nums[i];
            }
        }
        return index;
    }


    // 快慢指针思想： slow 走后面 ，fast 走前面，遇到不重复的数值就赋给 slow ，slow++
    public static int removeDuplicatesv2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int fast = 0 , slow = 0;
        while (fast < n){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }


    // 类似题：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
    // 0 0 1 1 2 2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode fast = head , slow = head;
        while (fast != null){
            if (fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
