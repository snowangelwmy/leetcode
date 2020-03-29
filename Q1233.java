/**
 * Test cases:
 * 1: Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * 2: Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
 * 3: Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        if(folder==null||folder.length==0) {
            return result;
        }

        Arrays.sort(folder);

        boolean[] deleteFlags = new boolean[folder.length];
        for(int i=0; i<folder.length-1; i++) {
            if(deleteFlags[i]) {
                continue;
            }
            for(int j=i+1; j<folder.length; j++) {
                if(deleteFlags[j]) {
                    continue;
                }
                if(folder[j].startsWith(folder[i]+"/")) {
                    deleteFlags[j] = true;
                }
            }
        }

        for(int i=0; i<folder.length; i++) {
            if(!deleteFlags[i]) {
                result.add(folder[i]);
            }
        }

        return result;
    }
}