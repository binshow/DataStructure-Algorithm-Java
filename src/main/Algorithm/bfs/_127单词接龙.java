package Algorithm.bfs;


import java.util.*;

// https://leetcode.cn/problems/word-ladder/
public class _127单词接龙 {


    //输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //输出：5
    //解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
    //

    public static void main(String[] args) {
        String[] wordList = new String[]{"hot","dot","dog","lot","log"};
        List<String> list = new ArrayList<>();
        for (String s : wordList) list.add(s);
        System.out.println(ladderLength("hit", "cog", list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String>  set = new HashSet<>(); // 记录路径
        queue.add(beginWord);
        int step = 1;
        while (queue.size() > 0){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (set.contains(cur)) continue;
                else set.add(cur);
                if (cur.equals(endWord)) return step;
                for(String tem : getWord(cur, wordList)) queue.add(tem);
            }
            step++;
        }
        return 0;
    }


    public static List<String> getWord(String word , List<String> wordList){
        List<String> res = new ArrayList<>();
        for (String s : wordList){
            // s 和 word 只有一个字母有区别
            if (s.length() != word.length()) continue;
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) diff++;
            }
            if (diff == 1) res.add(s);
        }
        return res;
    }



}
