/**
 * Test cases:
 * 1: Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * 2: Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * 3: Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * 4: Input: "/a/./b/../../c/"
 * Output: "/c"
 * 5: Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 6: Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Q71 {

    private static final String CUR = ".";

    private static final String UP = "..";

    private static final String SLASH = "/";

    public String simplifyPath(String path) {
        if(path==null||path.length()==0) {
            return path;
        }

        path = path.replaceAll("/{2,}", SLASH);
        if(path.length()>1 && path.lastIndexOf(SLASH)==path.length()-1) {
            path = path.substring(0, path.length()-1);
        }
        if(path.indexOf(SLASH)==0) {
            path = path.substring(1);
        }
        String[] dirs = path.split(SLASH);
        Stack<String> realDirs = new Stack<>();
        for(String dir : dirs) {
            if(!dir.equals(CUR) && !dir.equals(UP)) {
                realDirs.push(dir);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=dirs.length-1; i>=0; i--) {
            if(dirs[i].equals(CUR)) {
                continue;
            } else if(dirs[i].equals(UP)) {
                if(!realDirs.isEmpty()) {
                    realDirs.pop();
                }
            } else {
                if(!realDirs.isEmpty() && realDirs.peek().equals(dirs[i])) {
                    builder.insert(0, dirs[i]).insert(0, SLASH);
                    realDirs.pop();
                }
            }
        }
        return builder.toString().length() == 0 ? "/" : builder.toString();
    }
}