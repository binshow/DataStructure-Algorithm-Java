package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/279:49 PM
 */
public class _0_50_String {

    public static void main(String[] args) {
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq("abcdeac", words));
    }



    public static int numMatchingSubseq(String s, String[] words) {
        int n = s.length(), ans = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
       for (String a : words)
           if (check(a , map)) ans++;
        return ans;
    }

    // a c  d
    private static boolean check(String word, Map<Character, List<Integer>> map) {
        int l = -1;
        for (int i = 0 ; i < word.length() ; i++){
            int c = word.charAt(i) - 'a';
            int j = search(map.get(c) , l);
            if (j == map.get(c).size()) return false;
            i = map.get(c).get(j);
        }
        return false;
    }

    // list 中第一个大于num的数
    private static int search(List<Integer> list, int num) {
        return 0;
    }
}
