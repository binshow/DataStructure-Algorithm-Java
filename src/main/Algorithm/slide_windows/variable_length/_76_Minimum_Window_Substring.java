package Algorithm.slide_windows.variable_length;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/210:37 PM
 * 类似题：https://leetcode.cn/problems/shortest-supersequence-lcci/
 */
public class _76_Minimum_Window_Substring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

        String s = "anc";
        Arrays.sort(s.toCharArray());

    }

    //https://leetcode.cn/problems/minimum-window-substring/solution/76-zui-xiao-fu-gai-zi-chuan-hua-dong-chu-zfrc/
    public static  String minWindow(String s, String t) {
        Map<Character , Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c , need.getOrDefault(c , 0) + 1);

        Map<Character , Integer> win = new HashMap<>();
        int valid = 0;
        int start = 0 , len =  Integer.MAX_VALUE;

        //1. 声明窗口边界
        int l = 0  , r = 0;

        //2. 右边界开始滑动
        while (r < s.length()){
            char c = s.charAt(r);
            r++;

            //3. 窗口内数据更新
            if (need.containsKey(c)){
                win.put(c , win.getOrDefault(c , 0) + 1);
                if (win.get(c).equals(need.get(c))) valid++;  // ⭐注意：两个Integer类型的数据不能直接用< == >判断
            }

            //4. 判断左侧窗口是否要收缩
            while (valid == need.size()){

                // 5. 更新结果
                if (r - l < len ){
                    start = l ;
                    len = r - l;
                }

                char d = s.charAt(l);
                //6. 缩小左窗口
                l++;
                if (need.containsKey(d)){
                    win.put(d , win.getOrDefault(d , 0) - 1);
                    if (win.get(d) < need.get(d)) valid--;
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start , start + len);
    }
}
