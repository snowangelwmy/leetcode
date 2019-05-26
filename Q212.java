/**
 * Test cases:
 * 1: Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 */


import java.util.List;
import java.util.ArrayList;

class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board==null||board.length==0||board[0]==null||board[0].length==0||words==null||words.length==0) {
            return result;
        }

        TrieNode root = buildTrie(words);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode root, List<String> result) {
        char c = board[row][col];
        if(c=='#'||root.next[c-'a']==null) {
            return;
        }
        TrieNode next = root.next[c-'a'];
        if(next.word!=null) {
            result.add(next.word);
            next.word=null;
        }
        board[row][col] = '#';
        if(row>0) { dfs(board, row-1, col, next, result); }
        if(row<board.length-1) { dfs(board, row+1, col, next, result); }
        if(col>0) { dfs(board, row, col-1, next, result); }
        if(col<board[0].length-1) { dfs(board, row, col+1, next, result); }
        board[row][col] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode pointer = root;
            for(char c : word.toCharArray()) {
                int index = c-'a';
                if(pointer.next[index]==null) {
                    pointer.next[index] = new TrieNode();
                }
                pointer = pointer.next[index];
            }
            pointer.word = word;
        }
        return root;
    }

    private class TrieNode {
        private static final int COUNT = 26;
        private TrieNode[] next;
        private String word;

        public TrieNode() {
            next = new TrieNode[COUNT];
        }
    }
}