package tree;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/139:10 AM
 */
public class _02_Tree {


    //297. 二叉树的序列化与反序列化
    public static void main(String[] args) {
        long a = 22;
        int b = (int) a;

    }





    // https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/
    // 思路：二叉树的出度 和 入度
    //输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
    //输出: true
    public boolean isValidSerialization(String preorder) {
         int num = 0;
         for(int i = preorder.length()-1 ; i >= 0 ; i--){
             if (preorder.charAt(i) == ',') continue;
             if (preorder.charAt(i) == '#') num++;
             else {
                while (i > 0 && preorder.charAt(i) != ',') i--;
                if (num >= 2) num--;
                else return false;
             }
         }
         return num == 1;
    }


}
