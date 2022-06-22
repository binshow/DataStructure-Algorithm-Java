package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/unique-email-addresses/
 * @date 2022/6/48:28 PM
 */
public class Unique_Email_Addresses {
    // emails = local name + domain name
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (String s : emails){
            String[] str = s.split("@");
            String localName  = str[0];
            String domainName = str[1];
            localName = fixLocalName(localName);
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }


    String  fixLocalName (String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if (c == '.') continue;
            if (c == '+') break;
            sb.append(c);
        }
        return sb.toString();
    }
}
