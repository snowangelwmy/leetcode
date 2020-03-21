/**
 * Test cases:
 * 1: Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 */

class Q274 {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) {
            return 0;
        }

        int numOfPapers = citations.length;
        int[] nums = new int[numOfPapers+1];
        for(int i=0; i<numOfPapers; i++) {
            if(citations[i]>numOfPapers) {
                nums[numOfPapers]++;
            } else {//citations[i]<=citations.length
                nums[citations[i]]++;
            }
        }

        int temp = 0;
        for(int i=numOfPapers; i>=0; i--) {
            temp = temp + nums[i];
            if(temp>=i) {
                return i;
            }
        }
        return 0;
    }
}