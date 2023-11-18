package DataStructure.Array._出现m次问题;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _只出现一次的问题 {


    @Test
    void test(){

        //  101
        System.out.println(5 & 1); // 1
        System.out.println(5 & 2); // 0
        System.out.println(5 & 3); // 1

        System.out.println(5 >>> 1);

        System.out.println(singleNumber(new int[]{3, 3, 3, 2}));


    }



    //使用 与运算 ，可获取二进制数字 num 的最右一位  n = num & 1
    // 配合 无符号右移操作 ，可获取 num 所有位的值   num = num >>> 1



    // 011

    public int singleNumber(int[] nums) {

        // 记录所有数字的各二进制位的 111 的出现次数
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        System.out.println("统计所有数字二进制上出现1的次数：" + Arrays.toString(counts));

        //将 counts各元素对 3 求余，则结果为 “只出现一次的数字” 的各二进制位

        for(int i = 0 ; i < counts.length ; i++) counts[i] %= 3;
        System.out.println("取余之后的只出现1次的数字二进制：" + Arrays.toString(counts));

        // 通过 左移 和 或运算，将 count 数组的 1 恢复到结果res上
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            res <<= 1;

            res |= counts[31-i];
        }

        return res;

    }

    
    //https://leetcode.cn/problems/single-number-iii/description/
    public int[] singleNumberv3(int[] nums) {
        // 1. 把所有的元素进行异或操作，最终得到一个异或值。因为是不同的两个数字，所以这个值必定不为 0；
        int xor = 0;
        for(int num : nums) xor ^= num;

        // 2. 取异或值最后一个二进制位为 1 的数字作为 mask，如果是 1 则表示两个数字在这一位上不同
        int mask = xor & (-xor);

        // 3. 通过这个mask进行 与操作，为0的一个数字，为1的分为另外一个数组
        int[] res = new int[2];
        for(int num : nums){
            if( (num & mask) == 0) res[0] ^= num;
            else res[1] ^= num;
        }

        return res;

    }
}
