package string;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/validate-ip-address/
 * @date 2022/5/2911:17 PM
 */
public class Validate_IP_Address {

    public static void main(String[] args) {
        String s = "172.16.254.1";
        String s2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String s3 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validIPAddress(s3));
    }

    // 判断是否是有效的IP地址
    public static String validIPAddress(String queryIP) {
        if (isValidIPV4(queryIP)) return "IPv4";
        if (isValidIPV6(queryIP)) return "IPv6";
        return "Neither";
    }

    // ipv4的地址条件：x1.x2.x3.x4  , xi 需要在 [0,255]中，且 xi 不能以0开头
    private static boolean isValidIPV4(String ip){
        if (ip.length() < 7 || ip.charAt(0) =='.' || ip.charAt(ip.length()-1)=='.') return false;  // 注意这个条件
        String[] nums = ip.split("\\.");
        if (nums.length != 4) return false;
        for(String s : nums){
            //每一段字符串不能为0且不能以0开头的字符串，可以只有0
            if (s.length() == 0 || (s.charAt(0) == '0' && s.length() == 1 )) return false;
            int num = 0;
            for (char c : s.toCharArray()){
                if (!Character.isDigit(c)) return false;
                num = num * 10 + c - '0';
                if (num > 255) return false;
            }
        }
        return true;
    }

    // ipv6的地址条件： x1:x2:x3:x4:x5:x6:x7:x8  ， xi的长度[0,4]  xi中的字符只能在 A-F 或者 a-f 之间 或者 数字
    private static boolean isValidIPV6(String ip){
        //IPV6的地址至少有8个冒号和8个数字组成，必须要16个数
        if (ip.length() < 15 || ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':') return false;
        String[] nums = ip.split(":");
        if (nums.length != 8) return false;
        for(String s : nums){
           if (s.length() > 4 || s.length() == 0) return false;
           for (char c : s.toCharArray()){
              if (!isValidIPV6Char(c)) return false;
           }
        }
        return true;
    }

    private static boolean isValidIPV6Char(char c){
        if (Character.isDigit(c)) return true;
        if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) return true;
        return false;
    }
}
