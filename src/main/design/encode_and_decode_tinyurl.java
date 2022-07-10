package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * @date 2022/6/2910:21 AM
 */

// https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/
public class encode_and_decode_tinyurl {

    Map<String , String> map = new HashMap<>();
    static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
    static final String INDEX_PREFIX = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] chars = new char[6];
        while (true){
            for (int i = 0; i < 6; i++) {
                chars[i] = INDEX.charAt((int) (Math.random() * 62));
            }
            String shortUrl = INDEX_PREFIX + new String(chars);
            if (!map.containsKey(shortUrl)) map.put(shortUrl , longUrl);
            return shortUrl;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
