import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;

class Q17 {
    private static final Map<Character, String> lookup = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<String>();
        }
        List<String> combinations = new ArrayList<>();
        StringBuilder prefix = new StringBuilder(digits.length());
        letterCombinationsHelper(digits, 0, prefix, combinations);
        return combinations;
    }

    private void letterCombinationsHelper(String digits, int index, StringBuilder prefix, List<String> combinations) {
        if(index>=digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        Character num = Character.valueOf(digits.charAt(index));
        if(lookup.containsKey(num)) {
            String letters = lookup.get(num);
            for(int i=0; i<letters.length(); i++) {
                char c = letters.charAt(i);
                prefix.insert(index, c);
                letterCombinationsHelper(digits, index+1, prefix, combinations);
                prefix.deleteCharAt(index);
            }
        }
    }
}