package DataStructure.Array;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/duplicate-zeros/
 * @date 2022/6/179:24 AM
 * 相似题：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *       https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Duplicate_Zeros {

    //Input: arr = [1,0,2,3,0,4,5,0]
    //Output: [1,0,0,2,3,0,0,4]
    //Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
    //
    // 双指针模拟栈
    public void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) return;
        int n = arr.length;
        int top = 0;
        int i = -1;

        while (top < n){
            i++;
            if (arr[i] != 0) top++;
            else top += 2;
        }
        // 代码到这说明 只能复制 到原数组 i 的位置

        // 最后一个元素是不是0
        int j = n - 1;
        if (top == n + 1){
            arr[j] = 0;
            j--;
            i--;
        }

        while (j >= 0){
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0){
                arr[j] = arr[i];
                j--;
            }
            i--;
        }

    }
}
