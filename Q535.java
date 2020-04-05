/**
 * Test cases:
 * 1: Input: "https://leetcode.com/problems/design-tinyurl"
 * Output: "http://tinyurl.com/4e9iAk"
 */

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class Codec {

    //https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/491980/JAVA-One-of-the-EASIEST-Solutions-:)
    Map<String, String> longToShortMap = new HashMap<>();
    Map<String, String> shortToLongMap = new HashMap<>();
    private final static String prefix = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShortMap.containsKey(longUrl)) {
            return longToShortMap.get(longUrl);
        }

        String shortKey = UUID.randomUUID().toString().replace("-", "");
        while(shortToLongMap.containsKey(shortKey)) {
            shortKey = UUID.randomUUID().toString().replace("-", "");
        }
        longToShortMap.put(longUrl, prefix + shortKey);
        shortToLongMap.put(prefix + shortKey, longUrl);
        return longToShortMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!shortToLongMap.containsKey(shortUrl)) {
            return "Not Found";
        }

        return shortToLongMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));