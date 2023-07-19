package string;

//https://leetcode.cn/problemset/all/

public class _415字符串相加 {

    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("11", "2233"));
    }

    public static String addStrings(String s, String p) {
        if (s.equals("")) return p;
        if (p.equals("")) return s;

        int ls = s.length()-1;
        int lp = p.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (ls >= 0 || lp >= 0){
            int a = ls >= 0 ? s.charAt(ls) - '0' : 0;
            int b = lp >= 0 ? p.charAt(lp) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            ls--;
            lp--;
        }

        if (carry == 1) sb.append(1);
        return sb.reverse().toString();

    }

}
