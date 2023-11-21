package Algorithm.slide_windows;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/description/
public class _1156_单字符重复的最长字符串 {



    Map<Character , Integer> map = new HashMap<>();
    public int maxRepOpt1(String text) {

        // 先用一个 map 记录所有字符 及其出现的 次数

        for(char c : text.toCharArray()) map.put(c , map.getOrDefault(c,0) + 1);



        // 开始滑动窗口，记录单一字符的重复窗口
        int l = 0 , r = 0;
        int n = text.length();

        int[] count = new int[26];
        int res = 0;
        while(r < n){
            char c = text.charAt(r);
            count[c - 'a']++;
            while(!check(count)){
                char b = text.charAt(l);
                count[b - 'a']--;
                l++;
            }
            //System.out.println(Arrays.toString(count));
            res = Math.max(res , r - l + 1);
            r++;
        }
        return res;
    }

    // 判断 count 是否满足
    // 1. 只有一个数， return true
    // 2. 存在两个数，较小的为1，较大的 map 中还存在，return true
    // 3. 也可能两个都是1
    // 其余返回 false
    boolean check(int[] nums){
        int count = 0;
        int a = -1 , b = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                count++;
                if(a == -1) a = i;
                else b = i;
            }
        }

        if(count > 2) return false;
        if(count == 1) return true;


        // a 和 b 是两个索引

        if(nums[a] < nums[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        // a 大 b 小

        char c = (char)(a + 'a');
        char d = (char)(b + 'a');
        // System.out.println("a = " + c + " b = " + (char)(b + 'a'));
        if(nums[b] == 1 && map.get(c) > nums[a]) return true;

        // 有可能两个都是1
        if(nums[a] == 1 && nums[b] == 1 && (map.get(c) > nums[a] || map.get(d) > nums[b])) return true;
        return false;

    }
}
