/**
 * Test cases:
 * 1: Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> lookup = new HashMap<>();
        for(String str : strs) {
            String key = sortString(str);
            if(!lookup.containsKey(key)) {
                lookup.put(key, new ArrayList<String>());
            }
            lookup.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> value : lookup.values()) {
            result.add(value);
        }
        return result;
    }

    private String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}