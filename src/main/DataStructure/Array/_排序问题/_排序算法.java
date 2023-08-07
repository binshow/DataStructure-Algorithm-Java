package DataStructure.Array._排序问题;

import java.util.Arrays;

public class _排序算法 {

    // 快排
    public static void quickSort(int[] nums , int l , int r){
        if (l >= r) return;
        int mid = partition(nums , l , r);
        quickSort(nums , l , mid-1);
        quickSort(nums , mid + 1 , r);
    }

    static int partition(int[] nums , int left , int right){
        int base = nums[right];
        int l = left , r = right-1;
        while (l <= r){
            if (nums[l] < base) l++;
            else if (nums[r] > base) r--;
            else swap(nums , l++ , r--);
        }
        swap(nums , l , right);
        return l;
    }

   static void swap(int[] nums , int l , int r){
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        //quickSort(nums , 0 , nums.length-1);
        mergeSort(nums , 0 , nums.length-1);
        System.out.println(Arrays.toString(nums));

    }


    // 归并排序
    public static void mergeSort(int[] nums , int l , int r){
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(nums , l , mid);
        mergeSort(nums , mid+1 , r);

        //
        int[] tem = new int[r - l + 1];
        int index = 0;

        int i = l , j = mid + 1;
        while (i <= mid && j <= r){
            if (nums[i] < nums[j]) tem[index++] = nums[i++];
            else tem[index++] = nums[j++];
        }
        while (i <= mid) tem[index++] = nums[i++];
        while (j <= r) tem[index++] = nums[j++];

        // 拷贝回去
       for(i = 0 ; i < tem.length ; i++) nums[l + i] = tem[i];
    }
}
