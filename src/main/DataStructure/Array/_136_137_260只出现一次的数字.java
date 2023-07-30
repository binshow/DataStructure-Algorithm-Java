package DataStructure.Array;

public class _136_137_260只出现一次的数字 {


    //https://leetcode.cn/problems/single-number/
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }


    // https://leetcode.cn/problems/single-number-ii/
    // 其他数字出现了3次
    public int singleNumber2(int[] nums) {
        return -1;
    }


    // https://leetcode.cn/problems/single-number-iii/
    public int[] singleNumber3(int[] nums) {
        return null;
    }
}
