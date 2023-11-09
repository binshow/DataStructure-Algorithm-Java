package DataStructure.stack.parentheses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _1807_evaluate_the_bracket_pairs_of_string {


    //https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/description/



    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : knowledge) map.put(list.get(0) , list.get(1));


        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.empty() && stack.peek() != '(') sb.append(stack.pop());
                stack.pop();

                for(char tmp : map.getOrDefault(sb.reverse().toString() , "?").toCharArray()) stack.push(tmp);

            }else stack.push(c);
        }


        StringBuilder res = new StringBuilder();
        while(!stack.empty()) res.append(stack.pop());
        return res.reverse().toString();
    }


}
