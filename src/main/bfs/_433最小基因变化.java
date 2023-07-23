package bfs;

import java.util.*;

// https://leetcode.cn/problems/minimum-genetic-mutation/
public class _433最小基因变化 {


    //输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
    //输出：2
    //

    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

    public static int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Set<String> set = new HashSet<>(); // 保存路径
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        char[] letters = new char[]{'A' , 'C' , 'G' , 'T'};

        int step = 0;
        while (queue.size() > 0){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
               // System.out.println("cur :" + cur + " end: " + end);
                if (cur.equals(end)) return step;

                if (set.contains(cur)) continue;
                else set.add(cur);


                //遍历临近情况
                for (int j = 0; j < cur.length(); j++) {
                    for (char c : letters){

                        char[] chars = cur.toCharArray();
                        chars[j] = c;
                        String tem = new String(chars);

                        if(bankSet.contains(tem)){
                            queue.add(tem);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
