package DataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BrowserHistory {

    Stack<String> stack = new Stack<>(); // 保存返回的记录
    List<String> list = new ArrayList<>(); // 保存 forward 记录
    public BrowserHistory(String homepage) {
        stack.push(homepage);
    }

    public void visit(String url) {
        stack.push(url);
        list.clear();
    }

    public String back(int steps) {
        int n = Math.min(steps , stack.size()-1);
        while(n > 0){
            n--;
            list.add(stack.pop());
        }
        return stack.peek();
    }

    public String forward(int steps) {
        int n = Math.min(list.size() , steps);
        while(n > 0){
            n--;
            stack.push(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        return stack.peek();
    }

    public static void main(String[] args) {

        test02();

    }

    void test01(){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(1)); // facebook.com
        System.out.println(browserHistory.back(1)); // google.com

        System.out.println(browserHistory.forward(1)); // facebook.com
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        browserHistory.back(2);
        browserHistory.back(7);
    }

    static void test02(){
        BrowserHistory browserHistory = new BrowserHistory("zav.com");
        browserHistory.visit("kni.com");
        System.out.println(browserHistory.back(7)); // zav.com
        System.out.println(browserHistory.back(7)); // zav.com

        System.out.println(browserHistory.forward(5)); // kni.com


    }
}
