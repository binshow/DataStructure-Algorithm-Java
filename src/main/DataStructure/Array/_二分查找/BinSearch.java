package DataStructure.Array._二分查找;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/1912:10 PM
 */
public class BinSearch {


    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        // tail[i] 长度为i+1的上升子序列的末尾最小值
        int[] tail = new int[n];
        tail[0] = nums[0];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > tail[index]) tail[++index] = nums[i];
            else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int l = 0 , r = index;
                while (l < r){
                    int mid = l + r  >> 1;
                    if (nums[mid] < nums[i]) l = mid + 1;
                    else r = mid;
                }
                tail[l] = nums[i];
            }
            System.out.println(Arrays.toString(tail));
        }
        return index + 1;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);

        Map<Character , Character[]> map = new HashMap<>();
        map.put('2' , new Character[]{'a'});


    }

    // 寻找两个排序数组的第K大的元素
    public static int findKthNum(int[] nums1 , int l1 , int r1 , int[] nums2 , int l2 , int r2 , int k){
        int len1 = r1 - l1 + 1 , len2 = r2 - l2 + 1;
        if(len1 == 0) return nums2[l2 + k - 1];
        if(len2 == 0) return nums1[l1 + k - 1];
        if(k == 1) return Math.min(nums1[l1] , nums2[l2]);

        int i = l1 + Math.min(k/2 , len1) - 1;
        int j = l2 + Math.min(k/2 , len2) - 1;

        if(nums1[i] > nums1[j]) return findKthNum(nums1 , l1 , r1 , nums2 , j+1 , r2 , k - (j - l2 + 1));
        else return findKthNum(nums1 , i+1 , r1 , nums2 , l2 , r2 , k - (i-l1+1));
    }

   static int findKthNum2(int[] nums1 ,int l1 , int r1 , int[] nums2 , int l2 , int r2 , int k){
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;

        // 递归截止条件
        if(len1 == 0) return nums2[l2 + k -1];
        if(len2 == 0) return nums1[l1 + k -1];
        if(k == 1) return Math.min(nums1[l1] , nums2[l2]);

        // 每次两个数组都取二分之k个数
        int i = l1 + Math.min(len1 , k/2) - 1;
        int j = l2 + Math.min(len2 , k/2) - 1;

        // 比较两个数组的 k/2 的数的大小, 哪个数组更小，就干掉前面的 k/2个数
        //  1 3 5 7 9
        // 2 4 6 8 10
        if(nums1[i] > nums2[j]) return findKthNum(nums1 , l1 , r1 , nums2 , j+1 , r2 , k - (j-l2+1));
        else return findKthNum(nums1 , i+1 , r1 , nums2 , l2 , r2 , k - (i-l1+1));
    }
}
