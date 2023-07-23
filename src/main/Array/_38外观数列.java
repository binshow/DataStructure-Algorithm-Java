package Array;

// https://leetcode.cn/problems/count-and-say/
public class _38外观数列 {

    public static String countAndSay(int n) {

        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            char tem = s.charAt(0);
           // System.out.println("s: " + s  + " tem : " + tem);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == tem) count++;
                else  {
                    sb.append(count).append(tem);
                    //System.out.println(sb.toString());
                    tem = s.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(tem);  // 这里要添加
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
    }

}
