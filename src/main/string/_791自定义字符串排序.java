package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// https://leetcode.cn/problems/custom-sort-string/description/
public class _791自定义字符串排序 {

    @Test
    void test(){
        Assertions.assertEquals(customSortString2("cba", "abcd") , "cbad");
        char c = 'a';
        System.out.println( (char)(c - 32));
    }


    public String customSortString2(String order, String s) {
        StringBuilder sb = new StringBuilder();
        //1. 记录s中每个字符出现的次数
        int[] rec = new int[26];
        for (char c : s.toCharArray()) rec[c - 'a']++;

        //2. 遍历order，如果order中的字符也出现在s中，先加改字符
        for(char c : order.toCharArray()){
            if (rec[c - 'a'] != 0){
                for (int i = 0; i < rec[c - 'a']; i++) {
                    sb.append(c);
                }
            }
            rec[c - 'a'] = 0;
        }
        System.out.println(sb.toString());

        //3. 连接s中不存在 order 中的字符
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] != 0){
                for (int j = 0; j < rec[i]; j++) {
                    sb.append( (char) (i +'a'));
                }
            }
        }
        return sb.toString();

    }



    public String customSortString(String order, String s) {

        //1. 记录order中出现的 字符 和 顺序
        Map<Character , Integer> map = new HashMap<>();
        Map<Integer , Character> order2Char = new HashMap<>();
        for(int i = 0 ; i < order.length() ; i++) {
            map.put(order.charAt(i) , i);
            order2Char.put(i , order.charAt(i));
        }


        //2. 将s中的字符 标记一下，哪些是需要排序的
        // abcd ---> ---d  ---> 210
        char[] chars = s.toCharArray();
        List<Integer> sortList = new ArrayList<>();
        for(int i = 0 ; i < chars.length ; i++){
            if(map.containsKey(chars[i])) {
                sortList.add(map.get(chars[i]));
                chars[i] = '-';
            }
        }

        // System.out.println(Arrays.toString(chars));
        //System.out.println(sortList);

        //3. 将顺序进行排序
        Collections.sort(sortList);
        int index = 0;

        System.out.println(sortList);

        //4. 重新填充s中的字符
        for(int i = 0 ; i < chars.length ; i++){
            if (chars[i] == '-') chars[i] = order2Char.get(sortList.get(index++));
        }

        return new String(chars);

    }


}
