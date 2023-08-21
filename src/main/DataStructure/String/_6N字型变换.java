package DataStructure.String;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/zigzag-conversion/
public class _6N字型变换 {

    //输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    //

    // numRows = 4
    // i = 0 ,  span =  4 - 0 + 2 = 6
    // i = 1 ,  span =  4 - 1 + 2 =
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++) list.add(new StringBuilder());

        int index = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            list.get(index).append(s.charAt(i));
            if (index == 0 )  flag = 1;             // 从上下往下
            if (index == numRows - 1) flag = -1;    // 从下往上
            index += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
           // System.out.println(sb.toString());
            res.append(sb);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING" , 4));
    }
}
