package binary_search;

// https://leetcode.cn/problems/median-of-two-sorted-arrays/
public class _4寻找两个正序数组的中位数 {


    public static void main(String[] args) {
          int[] nums1 = new int[]{1,2};
          int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int a = findKth(nums1 , 0 , nums1.length-1 , nums2 , 0 , nums2.length-1 , (l1 + l2 + 1) /2 );
        int b = findKth(nums1 , 0 , nums1.length-1 , nums2 , 0 , nums2.length-1 , (l1 + l2 + 2) /2 );
        return (a + b) / 2.0;
    }

    private static int findKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if (len1 == 0) return nums2[l2 + k - 1];
        if (len2 == 0) return nums1[l1 + k - 1];
        if (k == 1) return Math.min(nums1[l1] , nums2[l2]);

        int i = l1 + Math.min(k / 2 , len1) - 1;
        int j = l2 + Math.min(k / 2 , len2) - 1;
       // System.out.println("i" + i + " , j = " + j + "k =" + k + "l2 = " + l2);
        if(nums1[i] > nums2[j]) return findKth(nums1 , l1 , r1 , nums2 , j+1 , r2 , k - (j-l2+1));
        else return findKth(nums1 , i+1 , r1 , nums2 , l2 , r2 , k - (i-l1+1));
    }

}
