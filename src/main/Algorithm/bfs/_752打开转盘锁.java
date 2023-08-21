package Algorithm.bfs;


// https://leetcode.cn/problems/open-the-lock/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _752打开转盘锁 {

    //输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //输出：6
    //解释：
    //可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
    //注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
    //因为当拨动到 "0102" 时这个锁就会被锁定。

    // 初始值为 0000
    public int openLock(String[] nums, String target) {

        Set<String> dead = new HashSet<>();
        for (String s : nums) dead.add(s);
        if (dead.contains(target)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int step = 0;
        Set<String> set = new HashSet<>(); //保存路径
        while (queue.size() > 0){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (dead.contains(cur)) continue;
                if (cur.equals(target)) return step;

                if (set.contains(cur)) continue;
                else set.add(cur);

                for (int j = 0; j < 4; j++) {
                    String a = plus(cur , j);
                    String b = minus(cur , j);
                    queue.add(a);
                    queue.add(b);
                }
            }
            step++;
        }
        return -1;

    }

    private String minus(String cur, int index) {
        char[] chars = cur.toCharArray();
        if (chars[index] == '0') chars[index] = '9';
        else chars[index]--;
        return new String(chars);
    }

    private String plus(String cur, int index) {
        char[] chars = cur.toCharArray();
        if (chars[index] == '9') chars[index] = '0';
        else chars[index]++;
        return new String(chars);
    }
}
