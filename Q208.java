/**
 * Test cases:
 * 1: Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */

class Trie {

    private static final int COUNT = 26;
    Trie[] children;
    String word;

    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[COUNT];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null) {
            return;
        }
        Trie cur = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.children[index]==null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null) {
            return false;
        }
        Trie cur = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.children[index]==null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.word!=null && cur.word.equals(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null) {
            return false;
        }
        if(prefix.length()==0) {
            return this.word.equals("");
        }
        Trie cur = this;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index]==null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */