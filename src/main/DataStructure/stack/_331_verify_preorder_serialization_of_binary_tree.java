package DataStructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _331_verify_preorder_serialization_of_binary_tree {

    //https://leetcode.cn/problems/create-maximum-number/description/


    //示例 1:
    //
    //输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
    //输出: true
    //示例 2:
    //
    //输入: preorder = "1,#"
    //输出: false
    //示例 3:
    //
    //输入: preorder = "9,#,#,1"
    //输出: false
    //

    @Test
    void test(){
        Assertions.assertEquals(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") , true);
    }


    /*
    *  先序遍历： 中左右
    *  遇到两个 # # 说明 是叶子结点，可以弹出该结点 并压入 #
    * */
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        Stack<String > stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (s.equals("#")){
                // 遇到两个 #
                while (!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if (stack.empty()) return false;
                    stack.pop(); // 弹出数字
                }
            }
            stack.push(s);
        }
        System.out.println(stack);
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
