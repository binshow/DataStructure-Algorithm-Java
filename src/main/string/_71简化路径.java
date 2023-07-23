package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _71简化路径 {

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strs){
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")){
                if (stack.size() > 0) stack.pop();
            }
            else stack.push(s);
        }

        LinkedList<String> list = new LinkedList<>();
        while (stack.size() > 0) list.addFirst(stack.pop());
        for(String tem : list) sb.append(tem).append("/");


        if (sb.length() > 1) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(simplifyPath("/home"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));

    }
}
