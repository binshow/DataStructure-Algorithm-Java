package Algorithm.dfs;

import java.util.Arrays;


//https://leetcode.cn/problems/bulb-switcher/description/
public class _319_灯泡开关 {



    // [0 , 0 , 0 , 0 , 0 , 0]
    // [1 , 1 , 1 , 1 , 1 , 1]   1
    // [1 , 0 , 1 , 0 , 1 , 0]   2
    // [1 , 0 , 0 , 0 , 1 , 1]   3
    // [1 , 0 , 0 , 1 , 1 , 1]   4
    // [1 , 0 , 0 , 1 , 0 , 1]   5
    // [1 , 0 , 0 , 1 , 0 , 0]   6
    public int bulbSwitch(int n) {
        int[] nums = new int[n];
        Arrays.fill(nums , 1);

        int index = 2;
        while(n > 1){
            help(nums , index++);
            n--;
        }

        int res = 0;
        for(int num : nums) res += num;
        return res;
    }


    void help(int[] nums , int index){
        for(int i = index - 1 ; i < nums.length ; i += index){
            nums[i] = nums[i] == 1 ? 0 : 1;
        }
    }


    //怎么理解`(int)Math.sqrt(n)`就是答案呢？
    //将n个开关，从`1...n`进行编号(一开始都是处于灯灭的状态)；
    //第1轮，切换的开关为`1,2,3...n`
    //第2轮，切换的开关为`2,4,6...`
    //第3轮，切换的开关为`3,6,9...`
    //...
    //第n轮，切换的开关为n
    //
    //反过来看：
    //第1栈灯，会在第1轮被切换状态
    //第2盏灯，会在第1,2轮被切换
    //第3盏灯，会在第1,3轮被切换
    //第4盏灯，会在第1,2,4轮被切换
    //第5盏灯，会在第1,5轮被切换
    //第6盏灯，会在第1,2,3,6轮被切换
    //第7盏灯，会在第1,7轮被切换
    //...
    //第n盏灯，会在第`n的因数`（包括1和n）轮被切换
    //
    //对于输入n，进行n轮切换后，被切换偶数次的灯会处于和最初相同的灯灭状态，被切换奇数次的灯会处于灯亮状态。
    //问题转换为，求`1,2,3,...,n`中，有多少个数有奇数个因数。
    //由于因数都是成对出现的，因此`只有完全平方数有奇数个因数`。因此，`<=n的数里面，有多少个完全平方数就是答案`。


}
