/**
 * Test cases:
 * 1: Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 *
 * 2: Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 */

class Q748 {
    private static final int NUM = 26;

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetFrequency = getFrequency(licensePlate);
        String shortestWord = null;
        for(String word : words) {
            int[] wordFrequency = getFrequency(word);
            if(isSuperSet(wordFrequency, targetFrequency) && (shortestWord==null || word.length() < shortestWord.length())) {
                shortestWord = word;
            }
        }
        return shortestWord;
    }

    private int[] getFrequency(String word) {
        int[] frequency = new int[NUM];
        for(char c : word.toCharArray()) {
            if(Character.isLetter(c)) {
                frequency[Character.toLowerCase(c)-'a']++;
            }
        }
        return frequency;
    }

    private boolean isSuperSet(int[] source, int[] target) {
        for(int i=0; i<NUM; i++) {
            if(source[i] < target[i]) { return false; }
        }
        return true;
    }
}