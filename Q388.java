/**
 * Test cases:
 * 1: Input: The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * Output: the longest absolute path is "dir/subdir2/file.ext", and its length is 20 (not including the double quotes).
 * 2: Input: The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 * Output: the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 */

class Q388 {
    public int lengthLongestPath(String input) {
        if(input==null||input.length()==0) {
            return 0;
        }

        String[] paths = input.split("\n");
        int[] lens = new int[paths.length+1];
        int maxLen = 0;
        for(int i=0; i<paths.length; i++) {
            String s = paths[i];
            int level = s.lastIndexOf("\t")+1;
            int curLen = lens[level] + s.length() - level + 1;
            lens[level+1] = curLen;
            if(s.contains(".")) {
                maxLen = Math.max(maxLen, curLen-1);
            }
        }
        return maxLen;
    }
}